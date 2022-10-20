package com.yixihan.bishi.xinye.q3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yixihan
 * @date 2022-10-20-19:34
 */
public class Main {

    /**
     * 任务类
     * 【无需改动】
     */
    static class Task {
        //任务id
        Long taskId;
        //配送任务类型=子任务类型之和
        Long taskType;
        //任务完成时间
        String date;

        public Task() {
        }

        public Long getTaskId() {
            return taskId;
        }

        public void setTaskId(Long taskId) {
            this.taskId = taskId;
        }

        public Long getTaskType() {
            return taskType;
        }

        public void setTaskType(Long taskType) {
            this.taskType = taskType;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }

    /**
     * 将输入的字符串任务转换为任务类的对象
     * 【无需改动】
     *
     * @param taskStr
     * @return
     */
    private static Task convertToTask(String taskStr) {
        String cleanTask = taskStr.substring(1, taskStr.length() - 1);
        String[] vars = cleanTask.split(",");
        String[] taskIdStr = vars[0].split(":");
        String[] dateStr = vars[1].split(":");
        String[] typeStr = vars[2].split(":");
        Task task = new Task();
        task.setTaskId(Long.parseLong(taskIdStr[1]));
        String date = dateStr[1];
        task.setDate(date.substring(1, date.length() - 1));
        task.setTaskType(Long.parseLong(typeStr[1]));
        return task;
    }

    /**
     * ACM模式输入输出处理【无需改动】
     *
     * @param args
     */
    public static void main(String[] args) {
        //ACM模式输入
        Scanner in = new Scanner(System.in);
        List<Task> tasks = new ArrayList<> ();
        int i = 0;
        long[] targetTasks = null;
        while (in.hasNext()) {
            if (i == 0) {
                String childCollectionStr = in.nextLine();
                String[] targetTypes = childCollectionStr.substring(1, childCollectionStr.length() - 1).split(",");
                targetTasks = new long[targetTypes.length];
                for (int j = 0; j < targetTypes.length; j++) {
                    targetTasks[j] = Long.parseLong(targetTypes[j]);
                }
            } else {
                tasks.add(convertToTask(in.nextLine()));
            }
            i++;
        }
        //题目逻辑计算
        String[] res = findTasks(tasks, targetTasks);
        //ACM模式输出
        System.out.println(Arrays.toString(res));
    }

    /**
     * 任务类型子集查询
     *
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param tasks       要查询已完成的配送任务的集合c
     * @param targetTasks 目标特定任务类型集合t
     * @return
     */
    public static String[] findTasks(List<Task> tasks, long[] targetTasks) {
        //todo 请实现此函数
        Arrays.sort (targetTasks);
        List<CustomHelper> helperList = new ArrayList<> ();
        boolean flag = false;
        int sum = 0;
        String startDate = "";
        String endDate = "";

        for (Task task : tasks) {
            if (Arrays.binarySearch (targetTasks, task.taskType) >= 0) {
                CustomHelper helper = new CustomHelper (targetTasks, task.getDate ());
                for (CustomHelper h : helperList) {
                    h.tasks.add (task.taskType);
                    if (h.equalsTask ()) {
                        h.endDate = task.getDate ();
                    }
                }
                helperList.add (helper);
            }
        }
        List<CustomHelper> helperList1 = new ArrayList<> ();
        for (CustomHelper h : helperList) {
            if (h.isOk ()) {
                flag = true;
                helperList1.add (h);
            }
        }
        long minSum = Long.MAX_VALUE;
        CustomHelper min = new CustomHelper ();
        for (CustomHelper h : helperList1) {
            if (minSum > h.dateSum ()) {
                min = h;
                minSum = h.dateSum ();
            }
        }

        for (long type : min.tasks) {
            for (int i = typeList.length - 1; i >= 0; i--) {
                if (type - typeList[i] >= 0) {
                    type -= typeList[i];
                    if (typeList[i] == 2) {
                        sum++;
                    }
                }
            }
        }


        return new String[]{flag ? "yes" : "no", min.startDate, min.endDate, String.valueOf (sum)};
    }

    static int[] typeList = {1, 2, 4, 8, 16};

    static class CustomHelper {
        String startDate = "";
        String endDate = "";
        List<Long> tasks;

        List<Long> targetTasks;

        public CustomHelper() {
        }

        public CustomHelper(long[] targetTasks) {
            this.targetTasks = new ArrayList<> ();
            this.tasks = new ArrayList<> ();
            for (long task : targetTasks) {
                this.targetTasks.add (task);
            }
        }

        public CustomHelper(long[] targetTasks, String startDate) {
            this (targetTasks);
            this.startDate = startDate;
        }

        public boolean equalsTask() {
            return targetTasks.equals (tasks);
        }

        private long dateSum() {
            SimpleDateFormat format = new SimpleDateFormat ();
            format.applyPattern ("yyyy-MM-dd");
            try {
                Date date1 = format.parse (startDate);
                Date date2 = format.parse (endDate);
                return date2.getTime () - date1.getTime ();
            } catch (ParseException e) {
                throw new RuntimeException ("");
            }
        }

        private boolean isOk() {
            return !"".equals (startDate) && !"".equals (endDate);
        }

        @Override
        public String toString() {
            return "CustomHelper{" + "startDate='" + startDate + '\'' + ", endDate='" + endDate + '\'' + ", tasks=" + tasks + ", targetTasks=" + targetTasks + '}';
        }
    }

}

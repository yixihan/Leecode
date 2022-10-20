package com.yixihan.bishi.xinye.q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author yixihan
 * @date 2022-10-20-19:35
 */
public class Main {

    /**
     * 货柜任务类
     * 【无需改动】
     */
    static class CounterTask {
        //货柜名称
        String counterName;
        //待做配送任务数
        Integer taskNum;

        public CounterTask() {
        }

        public Integer getTaskNum() {
            return taskNum;
        }

        public void setTaskNum(Integer taskNum) {
            this.taskNum = taskNum;
        }


        public String getCounterName() {
            return counterName;
        }

        public void setCounterName(String counterName) {
            this.counterName = counterName;
        }

        @Override
        public String toString() {
            return "CounterTask{" + "counterName='" + counterName + '\'' + ", taskNum=" + taskNum + '}';
        }
    }

    /**
     * 将输入的字符串货柜任务转换为货柜任务类的对象
     * 【无需改动】
     *
     * @param counterTaskStr
     * @return
     */
    private static CounterTask convertToCounterTask(String counterTaskStr) {
        String cleanStep = counterTaskStr.substring(1, counterTaskStr.length() - 1);
        String[] vars = cleanStep.split(",");
        String[] counterNameStr = vars[0].split(":");
        String[] numStr = vars[1].split(":");
        CounterTask task = new CounterTask();
        String cn = counterNameStr[1];
        task.setCounterName(cn.substring(1, cn.length() - 1));
        task.setTaskNum(Integer.parseInt(numStr[1]));
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
        List<CounterTask> strArr = new ArrayList<> ();
        int i = 0;
        String counterName = null;
        while (in.hasNext()) {
            if (i == 0) {
                counterName = in.nextLine();
            } else {
                strArr.add(convertToCounterTask(in.nextLine()));
            }
            i++;
        }
        //题目逻辑计算
        int res = counterTaskDone(strArr, counterName);
        //ACM模式输出
        System.out.println(res);
    }

    private static CounterTask planTask;

    /**
     * 货柜任务清零
     *
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param tasks       待做的货柜任务列表
     * @param counterName 要清零任务的货柜名称
     * @return 要清零该货柜上任务需要的天数
     */
    public static int counterTaskDone(List<CounterTask> tasks, String counterName) {
        //todo 请实现此函数
        int ans = getMinTaskNum (tasks, counterName);

        while (planTask.taskNum != 0) {
            for (CounterTask task : tasks) {
                System.out.println (task);
                if (task.taskNum <= 0) {
                    continue;
                }
                task.taskNum--;
                ans++;
            }
        }
        return ans;
    }


    private static int getMinTaskNum (List<CounterTask> tasks, String counterName) {
        int minTaskNum = Integer.MAX_VALUE;

        for (CounterTask task : tasks) {
            minTaskNum = Math.min (task.taskNum - 1, minTaskNum);
            if (task.counterName.equals (counterName)) {
                planTask = task;
            }
        }
        for (CounterTask task : tasks) {
            task.taskNum -= minTaskNum;
        }

        return minTaskNum;
    }
}

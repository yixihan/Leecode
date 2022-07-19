package com.yixihan.month10.day0719;

import java.util.TreeMap;

/**
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * <p>
 * MyCalendar 有一个 book(int start, int end)方法。
 * 它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * <p>
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 * <p>
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * 解释：
 * 前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
 * 第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
 * 第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
 * 第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
 * 时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
 *
 * @author : yixihan
 * @create : 2022-07-19-8:43
 */
public class MyCalendarTwo {

    private TreeMap<Integer, Integer> map = new TreeMap<> ();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        // 尝试添加至日程中
        map.put (start, map.getOrDefault (start, 0) + 1);
        map.put (end, map.getOrDefault (end, 0) - 1);

        // 记录活跃的日程数
        int active = 0;

        for (int cal : map.values ()) {
            // 以时间线统计日程
            active += cal;

            // 中途活跃日程 >= 3, 返回 false
            if (active >= 3) {

                // 恢复现场
                map.put (start, map.getOrDefault (start, 0) - 1);
                map.put (end, map.getOrDefault (end, 0) + 1);

                if (map.get (start) == 0) {
                    map.remove (start);
                }

                return false;
            }
        }

        return true;
    }
}

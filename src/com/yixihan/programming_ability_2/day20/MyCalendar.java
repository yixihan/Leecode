package com.yixihan.programming_ability_2.day20;

import java.util.Objects;
import java.util.TreeSet;

/**
 * 实现一个 MyCalendar 类来存放你的日程安排。
 * 如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * <p>
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * <p>
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end),
 * 实数 x 的范围为，  start <= x < end 。
 * <p>
 * 实现 MyCalendar 类：
 * <p>
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。
 * 否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 * <p>
 * 解释：
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
 * myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
 *
 * @author : yixihan
 * @create : 2022-04-11-14:01
 */
public class MyCalendar {

    TreeSet<Calendar> set;

    public MyCalendar() {
        set = new TreeSet<> (Calendar::compareTo);
    }

    public boolean book(int start, int end) {
        Calendar calendar = new Calendar (start, end);
        return set.add (calendar);
    }

    class Calendar implements Comparable<Calendar> {

        int start;
        int end;

        public Calendar() {
        }

        public Calendar(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Calendar)) {
                return false;
            }
            Calendar calendar = (Calendar) o;
            return start == calendar.start && end == calendar.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash (start, end);
        }

        @Override
        public int compareTo(Calendar o) {
            if (this.end <= o.start) {
                return -1;
            } else if (this.start >= o.end) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

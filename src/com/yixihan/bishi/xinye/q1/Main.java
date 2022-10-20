package com.yixihan.bishi.xinye.q1;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yixihan
 * @date 2022-10-20-19:04
 */
public class Main {

    public String[] dateArraysSort (String[] dates) {
        // write code here
        TreeSet<CustomDate> set = new TreeSet<> ();
        for (String str : dates) {
            set.add (strToDate (str));
        }
        String[] ans = new String[set.size ()];
        int index = 0;
        for (CustomDate date : set) {
            ans[index++] = formatDate (date);
        }

        return ans;
    }

    @Test
    public void test () {
        String[] dates = {"2051 293","2051 293","2004 60","2022 2", "2022 54"};
        System.out.println (Arrays.toString (dateArraysSort (dates)));
    }

    static Map<Integer, String> monthMap = new HashMap<> ();

    static {
        monthMap.put (1, "Jan");
        monthMap.put (2, "Feb");
        monthMap.put (3, "Apr");
        monthMap.put (4, "Apr");
        monthMap.put (5, "May");
        monthMap.put (6, "Jun");
        monthMap.put (7, "Jul");
        monthMap.put (8, "Aug");
        monthMap.put (9, "Sep");
        monthMap.put (10, "Oct");
        monthMap.put (11, "Nov");
        monthMap.put (12, "Dec");
    }

    private String formatDate (CustomDate date) {
        StringBuilder sb = new StringBuilder ();
        sb.append (date.day);
        if (date.day % 10 == 1) {
            sb.append ("st");
        } else if (date.day % 10 == 2) {
            sb.append ("nd");
        } else if (date.day % 10 == 3) {
            sb.append ("rd");
        } else {
            sb.append ("th");
        }

        sb.append (" ").append (monthMap.get (date.month)).append (" ").append (date.year);
        return sb.toString ();
    }

    static int[] sumDay = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    private CustomDate strToDate (String str) {
        String[] split = str.split (" ");
        int year = Integer.parseInt (split[0]);
        int day = Integer.parseInt (split[1]);

        return getDate(year, day);
    }

    private CustomDate getDate (int year, int day) {
        int month = 0;
        // 闰年
        if (judgeYear (year)) {
            day -= 1;
        }

        for (int i = 0; i < sumDay.length; i++) {
            if (day <= sumDay[i]) {
                month = i + 1;
                if (i > 0) {
                    day -= sumDay[i - 1];
                }
                break;
            }
        }


        return new CustomDate (year, month, judgeYear (year) ? day + 1 : day);
    }

    private boolean judgeYear (int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static class CustomDate implements Comparable<CustomDate>{
        int year;
        int month;
        int day;

        public CustomDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CustomDate)) return false;
            CustomDate that = (CustomDate) o;
            return year == that.year && month == that.month && day == that.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash (year, month, day);
        }

        @Override
        public String toString() {
            return "CustomDate{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
        }

        @Override
        public int compareTo(CustomDate o) {
            if (year != o.year) {
                return Integer.compare (year, o.year);
            } else if (month != o.month) {
                return Integer.compare (month, o.month);
            } else {
                return Integer.compare (day, o.day);
            }
        }
    }


}

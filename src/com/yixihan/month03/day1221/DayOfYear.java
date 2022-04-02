package com.yixihan.month03.day1221;

import java.text.SimpleDateFormat;

/**
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 *
 * 输入：date = "2003-03-01"
 * 输出：60
 *
 * 输入：date = "2004-03-01"
 * 输出：61
 *
 * @author : yixihan
 * @create : 2021-12-21-8:40
 */
public class DayOfYear {

    private static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static {
        for (int i = 1; i < months.length; i++) {
            months[i] += months[i - 1];
        }
    }

    public int dayOfYear(String date) {

        String[] split = date.split ("-");
        int year = Integer.parseInt (split[0]);
        int month = Integer.parseInt (split[1]);
        int day = Integer.parseInt (split[2]);
        boolean leap = judgeLeapYear (year);

        System.out.println (year + "-" + month + "-" + day + ", :: " + leap);

        return months[month - 1] + day + (leap & month > 2 ? 1 : 0);
    }

    private boolean judgeLeapYear (int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}

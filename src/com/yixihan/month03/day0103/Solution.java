package com.yixihan.month03.day0103;

/**
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"data.txt", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："data.txt"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："data.txt"
 *
 * @author : yixihan
 * @create : 2022-01-03-14:31
 */
public class Solution {

    /**
     * 蔡勒公式
     * c 是世纪数减一，也就是年份的前两位。
     * y 是年份的后两位。
     * m 是月份。m 的取值范围是 3 至 14，因为某年的 1、2 月要看作上一年的 13、14月，
     * 比如 2019 年的 1 月 1 日要看作 2018 年的 13 月 1 日来计算。
     * d 是日数。
     * W = D%7 是结果代表一周中第几天, 0 为周日
     * 由于最后计算 D 可能为负数，需要处理一下。
     * 方法很多：这里由 D 计算式发现减的内容最大为 199 所以可以加上一个大于 199 且是 7 的倍数的数，我随便取一个 210 加上保证结果为正。
     */
    public String dayOfTheWeek(int day, int month, int year) {

        String[] weeks = new String[] {"data.txt", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int c = year / 100;
        year %= 100;
        //加上30*7防止出现负数
        int D = c / 4 - 2 * c + year + year / 4 + 13 * (month + 1) / 5 + day - 1 + 210;
        return weeks[D % 7];
    }
}

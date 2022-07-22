package com.yixihan.month10.day0722;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
 * <p>
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * <p>
 * 输出这个最小集合S的大小。
 * <p>
 * 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 * 输出: 3
 * 解释:
 * 考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
 * 且这是S最小的情况，故我们输出3。
 * <p>
 * 输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 * 输出: 5
 * 解释:
 * 最小的集合S = {1, 2, 3, 4, 5}.
 *
 * @author : yixihan
 * @create : 2022-07-22-8:51
 */
public class Solution {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort (intervals, Comparator.comparingInt (a -> a[1]));
        int a = intervals[0][1] - 1;
        int b = intervals[0][1];
        int ans = 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            int l = ints[0], r = ints[1];
            if (l > b) {
                ans += 2;
                a = r - 1;
                b = r;
            } else if (l == b || l > a) {
                ans += 1;
                a = b;
                b = r;
            }
        }
        return ans;
    }
}

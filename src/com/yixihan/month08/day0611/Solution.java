package com.yixihan.month08.day0611;

/**
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * <p>
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 *
 * @author : yixihan
 * @create : 2022-06-11-12:34
 */
public class Solution {

    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray ();
        int n = arr.length;
        int[][] dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            if (arr[i - 1] == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min (dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min (dp[i - 1][0], dp[i - 1][1]);
            }
        }

        return Math.min (dp[n][0], dp[n][1]);
    }
}

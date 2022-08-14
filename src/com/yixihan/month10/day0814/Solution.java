package com.yixihan.month10.day0814;

import java.util.Arrays;

/**
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * <p>
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * <p>
 * 输入：s = "011101"
 * 输出：5
 * 解释：
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 * <p>
 * 输入：s = "00111"
 * 输出：5
 * 解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
 * <p>
 * 输入：s = "1111"
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-08-14-9:13
 */
public class Solution {

    public int maxScore(String s) {

        char[] arr = s.toCharArray ();
        int len = arr.length;
        int[][] dp = new int[len + 1][2];
        int index = 1;
        int ans = 0;

        for (char c : arr) {
            if (c == '1') {
                dp[index][0] = dp[index - 1][0];
                dp[index][1] = dp[index - 1][1] + 1;
            } else {
                dp[index][0] = dp[index - 1][0] + 1;
                dp[index][1] = dp[index - 1][1];
            }
            index++;
        }

        for (int[] ints : dp) {
            System.out.println (Arrays.toString (ints));
        }

        for (int i = 1; i <= len; i++) {
            System.out.println ("0 : " + dp[i][0] + ", 1 : " + (dp[len][1] - dp[i][1]));
            ans = Math.max (dp[i][0] + dp[len][1] - dp[i][1], ans);
        }

        return ans;
    }
}

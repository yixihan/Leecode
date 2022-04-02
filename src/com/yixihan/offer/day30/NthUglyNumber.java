package com.yixihan.offer.day30;

import java.util.*;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * @author : yixihan
 * @create : 2022-03-21-19:18
 */
public class NthUglyNumber {

    /**
     * 每一个丑数都由比它小的丑数 * 2/ 3/ 5 得到
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        int id2 = 0;
        int id3 = 0;
        int id5 = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min (dp[id2] * 2, Math.min (dp[id3] * 3, dp[id5] * 5));
            if (dp[id2] * 2 == dp[i]) {
                id2++;
            }
            if (dp[id3] * 3 == dp[i]) {
                id3++;
            }
            if (dp[id5] * 5 == dp[i]) {
                id5++;
            }
        }


        return dp[n - 1];
    }
}

package com.yixihan.month06.day0411;

/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 * <p>
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 *
 * @author : yixihan
 * @create : 2022-04-11-13:52
 */
public class Solution {

    int[] ans = {1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851};

    public int countNumbersWithUniqueDigits(int n) {
        // 枚举
//        return ans[n];
        /*
        f(0) = 1
        f(1) = 9 + f(0)
        f(2) = 9 * 9 + f(1)
        f(3) = 9 * 9 * 8 + f(2)
        f(4) = 9 * 9 * 8 * 7 + f(3)
        ...
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int sum = 9;
            int tmp = i;

            while (tmp > 1) {
                tmp--;
                sum *= 10 - tmp;
            }

            dp[i] = sum + dp[i - 1];
        }
        return dp[n];
    }
}

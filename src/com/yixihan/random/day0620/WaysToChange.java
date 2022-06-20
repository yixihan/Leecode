package com.yixihan.random.day0620;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * @author : yixihan
 * @create : 2022-06-20-15:32
 */
public class WaysToChange {
    public int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int ans = 0;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin] % mod;
            }
        }

        return dp[n] % mod;

    }
}

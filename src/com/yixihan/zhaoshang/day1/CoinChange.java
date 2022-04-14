package com.yixihan.zhaoshang.day1;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-04-14-17:15
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }

            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    static class Main {
        public static void main(String[] args) {
            int[] coins = new int[]{411,412,413,414,415,416,417,418,419,420,421,422};
            System.out.println (new CoinChange ().coinChange (coins, 9864));
        }
    }
}

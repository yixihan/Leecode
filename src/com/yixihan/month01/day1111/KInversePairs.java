package com.yixihan.month01.day1111;

/**
 * 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 *
 * 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
 *
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 *
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释:
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 *
 * 输入: n = 3, k = 1
 * 输出: 2
 * 解释:
 * 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 *
 * @author : yixihan
 * @create : 2021-11-11-18:37
 */
public class KInversePairs {

    int MOD = 1000000007;


    /**
     * 动态规划
     */
    public int kInversePairs1 (int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= Math.min(k, i * (i - 1) / 2); j++) {
                for (int x = Math.max(0, j - i + 1); x <= j; x++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][x]) % MOD;
                }
            }
        }

        return (int) dp[n][k];
    }


    /**
     * 动态规划 --- 压缩时间
     */
    public int kInversePairs2 (int n, int k) {

        long[][] dp = new long[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= Math.min(k, i * (i - 1) / 2); j++) {

                dp[i][j] = ((j >= 1 ? dp[i][j - 1] : 0) + dp[i - 1][j] - (j >= i ? dp[i - 1][j - i] : 0) + MOD) % MOD;
            }
        }

        return (int) dp[n][k];
    }


    /**
     * 动态规划 --- 压缩空间
     */
    public int kInversePairs(int n, int k) {

        long[][] dp = new long[2][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= Math.min(k, i * (i - 1) / 2); j++) {

                dp[i & 1][j] = ((j >= 1 ? dp[i & 1][j - 1] : 0) + dp[(i - 1) & 1][j] - (j >= i ? dp[(i - 1) & 1][j - i] : 0) + MOD) % MOD;
            }
        }

        return (int) dp[n & 1][k];
    }
}

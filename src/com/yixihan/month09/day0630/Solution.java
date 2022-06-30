package com.yixihan.month09.day0630;

/**
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * <p>
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * <p>
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * <p>
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * <p>
 * 输入：n = 100
 * 输出：682289015
 *
 * @author : yixihan
 * @create : 2022-06-30-10:33
 */
public class Solution {
    public int numPrimeArrangements(int n) {
        int sum = 0;
        int mod = 1000000007;
        if (n > 2) {
            sum = helper (n);
        } else {
            return 1;
        }

        long cur = 1L;
        for (int i = 2; i <= sum; i++) {
            cur = (cur * i) % mod;
        }
        for (int i = 2; i <= n - sum; i++) {
            cur = (cur * i) % mod;
        }

        return (int) cur;
    }

    private int helper(int n) {
        n++;
        int sum = 0;
        boolean[] bool = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (!bool[i]) {
                sum++;
                for (int j = 2; j * i < n; j++) {
                    bool[j * i] = true;
                }
            }
        }

        return sum;
    }
}

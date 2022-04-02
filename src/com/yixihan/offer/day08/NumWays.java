package com.yixihan.offer.day08;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-02-28-12:57
 */
public class NumWays {
    public static final double MOD = 1e9 + 7;

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int a = 1;
        int b = 1;

        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a %= MOD;
        }

        return a;

    }
}

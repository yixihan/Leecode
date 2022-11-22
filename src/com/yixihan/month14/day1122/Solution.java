package com.yixihan.month14.day1122;

/**
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * <p>
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * <p>
 * 输入：n = 1, a = 2, b = 3
 * 输出：2
 * <p>
 * 输入：n = 4, a = 2, b = 3
 * 输出：6
 *
 * @author yixihan
 * @date 2022/11/22 9:01
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        int c = a * b / gcd (a, b);
        long l = 0, r = (long) (a + b) * n;
        while (l < r) {
            long mid = l + r >>> 1;
            if (mid / a + mid / b - mid / c >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (l % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd (b, a % b);
    }
}

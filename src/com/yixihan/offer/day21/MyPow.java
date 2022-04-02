package com.yixihan.offer.day21;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * @author : yixihan
 * @create : 2022-03-12-10:36
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }

        double half = myPow (x, n / 2);
        double mod = myPow (x, n % 2);
        return half * half * mod;
    }
}

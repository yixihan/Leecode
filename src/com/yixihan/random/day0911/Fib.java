package com.yixihan.random.day0911;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *
 * @author : yixihan
 * @create : 2022-09-11-10:27
 */
public class Fib {

    public int fib(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            a = a + b;
            b = a - b;
        }

        return a;
    }
}

package com.yixihan.binary.day4;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 输入：x = 4
 * 输出：2
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去
 *
 * @author : yixihan
 * @create : 2022-03-31-0:29
 */
public class MySqrt {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid < x) {
                left = mid + 1;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                return (int) mid;
            }
        }

        return (int) right;
    }
}

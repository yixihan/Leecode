package com.yixihan.random.day0807;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * @author : yixihan
 * @create : 2022-08-07-9:19
 */
public class Divide {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        // 用异或来计算是否符号相异
        negative = (dividend ^ divisor) < 0;
        long t = Math.abs ((long) dividend);
        long d = Math.abs ((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            // 找出足够大的数 2 ^ n * divisor
            if ((t >> i) >= d) {
                // 将结果加上2^n
                result += 1 << i;
                // 将被除数减去2 ^ n * divisor
                t -= d << i;
            }
        }
        // 符号相异取反
        return negative ? -result : result;
    }
}

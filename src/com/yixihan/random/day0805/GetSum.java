package com.yixihan.random.day0805;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * <p>
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>
 * 输入：a = 2, b = 3
 * 输出：5
 *
 * @author : yixihan
 * @create : 2022-08-05-9:03
 */
public class GetSum {

    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getSum (a ^ b, (a & b) << 1);
    }
}

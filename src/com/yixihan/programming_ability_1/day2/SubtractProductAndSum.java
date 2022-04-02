package com.yixihan.programming_ability_1.day2;

/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *
 * @author : yixihan
 * @create : 2022-03-12-11:47
 */
public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {

        // 方法一 : 暴力解法
        int sum = 0;
        int product = 1;

        for (int i = n; i > 0; i /= 10) {
            sum += i % 10;
            product *= i % 10;
        }


        return product - sum;
    }
}

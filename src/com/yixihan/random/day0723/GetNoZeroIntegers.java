package com.yixihan.random.day0723;

/**
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * <p>
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * <p>
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 * <p>
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 * <p>
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
 * <p>
 * 输入：n = 11
 * 输出：[2,9]
 * <p>
 * 输入：n = 10000
 * 输出：[1,9999]
 * <p>
 * 输入：n = 69
 * 输出：[1,68]
 * <p>
 * 输入：n = 1010
 * 输出：[11,999]
 *
 * @author : yixihan
 * @create : 2022-07-23-10:11
 */
public class GetNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int num1 = i;
            int num2 = n - i;

            if (!Integer.toString (num1).contains ("0") && !Integer.toString (num2).contains ("0")) {
                return new int[]{num1, num2};
            }
        }

        return new int[]{};
    }
}

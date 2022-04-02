package com.yixihan.programming_ability_1.day1;

/**
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 *
 *
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 *
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 *
 * @author : yixihan
 * @create : 2022-03-11-14:52
 */
public class CountOdds {

    /**
     * [low, high] 中间的数 = high - low + 1
     * 中间的数 = 偶数, 奇数为一半
     * 中间的数 = 奇数, 奇数看边界的奇偶性
     *
     */
    public int countOdds(int low, int high) {

        int val = (high - low + 1);

        if (val % 2 == 0) {
            return val / 2;
        } else {
            return low % 2 == 0 ? val / 2 : val / 2 + 1;
        }

    }
}

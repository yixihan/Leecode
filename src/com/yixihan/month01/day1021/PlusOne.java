package com.yixihan.month01.day1021;

import org.junit.jupiter.api.Test;
/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 输入：digits = [0]
 * 输出：[1]
 * @author yixihan
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int n = digits.length;

        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    @Test
    public void test () {
        int[] i2 = {1, 2, 3, 5, 8, 9};
        int[] i1 = {9,9,9,9,9,9,9,9};

        int[] ints1 = plusOne(i2);

        for (int i : ints1) {
            System.out.print(i + " ");
        }


    }
}

class Solution {

}

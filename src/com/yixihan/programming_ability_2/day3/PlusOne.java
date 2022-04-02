package com.yixihan.programming_ability_2.day3;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 *
 * @author : yixihan
 * @create : 2022-03-25-14:23
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        digits[n - 1]++;

        for (int i = n - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i] -= 10;
                digits[i - 1]++;
            } else {
                break;
            }
        }

        if (digits[0] == 10) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            ans[1] = 0;

            System.arraycopy (digits, 1, ans, 2, n - 1);

            return ans;
        } else {
            return digits;
        }
    }
}

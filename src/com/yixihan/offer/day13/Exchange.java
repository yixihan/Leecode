package com.yixihan.offer.day13;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * @author : yixihan
 * @create : 2022-03-05-14:19
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int indexI = 0;
        int indexJ = length - 1;

        for (int num : nums) {
            if (num % 2 != 0) {
                ans[indexI++] = num;
            } else {
                ans[indexJ--] = num;
            }
        }

        return ans;
    }
}

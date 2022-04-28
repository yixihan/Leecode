package com.yixihan.month07.day0428;

/**
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * <p>
 * 返回满足此条件的 任一数组 作为答案。
 * <p>
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 *
 * @author : yixihan
 * @create : 2022-04-28-10:06
 */
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] % 2 != 0 && nums[r] % 2 == 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }

            while (l < r && nums[l] % 2 == 0) {
                l++;
            }

            while (l < r && nums[r] % 2 != 0) {
                r--;
            }


        }

        return nums;
    }
}

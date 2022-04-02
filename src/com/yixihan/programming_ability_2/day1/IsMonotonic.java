package com.yixihan.programming_ability_2.day1;

/**
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 * <p>
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。
 * 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 * <p>
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 * <p>
 * <p>
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * <p>
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * <p>
 * 输入：nums = [1,3,2]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-03-23-11:08
 */
public class IsMonotonic {
    public boolean isMonotonic(int[] nums) {
        int flag = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (flag == -1) {
                    return false;
                } else if (flag == 0) {
                    flag = 1;
                }
            } else if (nums[i + 1] > nums[i]) {
                if (flag == 1) {
                    return false;
                } else if (flag == 0) {
                    flag = -1;
                }
            }
        }

        return true;
    }
}

package com.yixihan.month13.day1024;

/**
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * <p>
 * 用例可以保证存在这样的划分方法。
 * <p>
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * <p>
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *
 * @author yixihan
 * @date 2022-10-24-19:30
 */
public class Solution {

    public int partitionDisjoint(int[] nums) {
        int lMax = nums[0];
        int max = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max (max, nums[i]);

            if (nums[i] < lMax) {
                lMax = max;
                index = i;
            }
        }

        return index + 1;
    }
}

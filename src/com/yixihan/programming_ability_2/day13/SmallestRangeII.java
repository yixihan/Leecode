package com.yixihan.programming_ability_2.day13;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
 * <p>
 * nums 的 分数 是 nums 中最大元素和最小元素的差值。
 * <p>
 * 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
 * <p>
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
 * <p>
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
 * <p>
 * 输入：nums = [1,3,6], k = 3
 * 输出：3
 * 解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3
 *
 * @author : yixihan
 * @create : 2022-04-04-15:38
 */
public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort (nums);
        int n = nums.length;

        int res = nums[n - 1] - nums[0];

        for (int i = 1; i < n; i++) {
            int min = Math.min (nums[0] + k, nums[i] - k);
            int max = Math.max (nums[n - 1] - k, nums[i - 1] + k);
            res = Math.min (max - min, res);
        }
        return res;
    }
}

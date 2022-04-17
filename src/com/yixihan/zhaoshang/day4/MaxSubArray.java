package com.yixihan.zhaoshang.day4;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * @author : yixihan
 * @create : 2022-04-17-15:23
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }

        int ans = dp[0];
        for (int i = 0; i < n; i++) {
            ans = Math.max (ans, dp[i]);
        }

        return ans;
    }
}

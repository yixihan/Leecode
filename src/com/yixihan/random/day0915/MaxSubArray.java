package com.yixihan.random.day0915;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * <p>
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author : yixihan
 * @create : 2022-09-15-10:40
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            max = Math.max (dp[i], max);
        }

        return max;
    }
}

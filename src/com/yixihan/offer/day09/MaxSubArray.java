package com.yixihan.offer.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author : yixihan
 * @create : 2022-03-01-12:20
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];


        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
        }

        System.out.println (Arrays.toString (dp));

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            max = Math.max (dp[i], max);
        }

        return max;
    }
}

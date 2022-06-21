package com.yixihan.random.day0621;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * <p>
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * <p>
 * abs(x) 定义如下：
 * <p>
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 *
 * @author : yixihan
 * @create : 2022-06-21-9:53
 */
public class MaxAbsoluteSum {

    /**
     * 绝对值的最大值 = 前缀和数组的最大值 - 最小值
     *
     * @param nums
     * @return
     */
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = nums[i - 1] + dp[i - 1];
        }
        System.out.println (Arrays.toString (dp));

        int maxVal = dp[0];
        int minVal = dp[0];

        for (int i = 1; i <= n; i++) {
            maxVal = Math.max (maxVal, dp[i]);
            minVal = Math.min (minVal, dp[i]);
        }

        return maxVal - minVal;
    }
}

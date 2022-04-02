package com.yixihan.data_structure_1.day1;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 输入：nums = [1]
 * 输出：1
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * @author : yixihan
 * @create : 2022-03-11-14:08
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        // 方式一 : 瞎几把乱做之我也不知道这是啥解法
//        int n = nums.length;
//        int[] arr = new int[n];
//        arr[0] = nums[0];
//
//        for (int i = 1; i < n; i++) {
//            if (nums[i] + arr[i - 1] > Math.max (0, nums[i])) {
//                arr[i] = arr[i - 1] + nums[i];
//            } else {
//                arr[i] = nums[i];
//            }
//        }
//
//        return Arrays.stream(arr).max ().getAsInt ();

        // 方式二 : 动态规划
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
        return Arrays.stream(dp).max ().getAsInt ();

    }
}

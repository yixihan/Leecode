package com.yixihan.random.day0913;

import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。：
 *
 * 输入：nums = [1,2,3]
 * 输出：6
 *
 * 输入：nums = [1,2,3,4]
 * 输出：24
 *
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 *
 * @author : yixihan
 * @create : 2022-09-13-11:42
 */
public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort (nums);
        int n = nums.length;


        return Math.max (nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}

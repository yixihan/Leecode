package com.yixihan.random.day0914;

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 *
 * @author : yixihan
 * @create : 2022-09-14-10:27
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double maxSum = Integer.MIN_VALUE;
        double sum = 0;
        int l = 0;
        int r = 0;

        while (r < len) {
            sum += nums[r];
            while (r - l + 1 > k) {
                sum -= nums[l++];
            }
            // System.out.println ("l : " + l + " r : " + r + " sum : " + sum);
            if (r - l + 1 == k) {
                maxSum = Math.max (sum, maxSum);
            }
            r++;
        }

        return maxSum / k;
    }
}

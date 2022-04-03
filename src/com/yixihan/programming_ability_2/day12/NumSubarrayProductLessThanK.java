package com.yixihan.programming_ability_2.day12;

/**
 * 给定一个正整数数组 nums和整数 k 。
 * <p>
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * <p>
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 * <p>
 *
 * @author : yixihan
 * @create : 2022-04-03-15:05
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int pro = 1;
        int head = -1;

        for (int i = 0; i < n; ++i) {
            pro *= nums[i];

            while (pro >= k && head < i) {
                pro /= nums[++head];
            }
            ans += i - head;
        }

        return ans;
    }
}

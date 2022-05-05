package com.yixihan.month07.day0505;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-05-05-13:19
 */
public class Solution {
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

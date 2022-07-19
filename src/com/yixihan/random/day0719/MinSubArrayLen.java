package com.yixihan.random.day0719;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-07-19-10:28
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int count = 0;

        for (int right = 0; right < len; right++) {
            sum += nums[right];
            count++;
            while (left <= right && sum >= target) {
                ans = Math.min (count, ans);
                sum -= nums[left++];
                count--;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }
}

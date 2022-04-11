package com.yixihan.binary_2.day1;

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
 * @create : 2022-04-11-15:14
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {

        // 暴力 ? (前缀和)
        //        int n = nums.length;
        //        int[] dp = new int[n + 1];
        //        dp[0] = 0;
        //
        //        for (int i = 1; i <= n; i++) {
        //            dp[i] = nums[i - 1] + dp[i - 1];
        //        }
        //
        //        int ans = Integer.MAX_VALUE;
        //        for (int i = n; i >= 0; i--) {
        //            if (dp[i] < target) {
        //                break;
        //            }
        //
        //            for (int j = i - 1; j >= 0; j--) {
        //                if (target <= dp[i] - dp[j]) {
        //                    ans = Math.min (ans, i - j);
        //                }
        //            }
        //        }
        //
        //        return ans == Integer.MAX_VALUE ? 0 : ans;

        // 滑动窗口
        //        int i = 0;
        //        int sum = 0;
        //        int ans = 0;
        //        int n = nums.length;
        //
        //        for (int j = 0; j < n; j++) {
        //            sum += nums[j];
        //
        //            while (sum >= target) {
        //                ans = ans == 0 ? j - i + 1 : Math.min (ans, j - i + 1);
        //                sum -= nums[i++];
        //            }
        //        }
        //
        //        return ans;

        // 双指针
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < n) {
            while (sum < target && right < n) {
                sum += nums[right++];
            }

            while (sum >= target && left >= 0) {
                ans = Math.min (ans, right - left);
                sum -= nums[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

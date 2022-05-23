package com.yixihan.binary_2.day15;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 *
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 *
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 *
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 *
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 *
 * @author : yixihan
 * @create : 2022-05-23-13:04
 */
public class NumSubseq {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort (nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        long[] rs = new long[nums.length];
        rs[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            rs[i] = (rs[i - 1] << 1) % 1000000007;
        }

        while (left <= right) {

            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                ans = (ans + (int) rs[right - left]) % 1000000007;
                left++;
            }
        }

        return ans;
    }
}

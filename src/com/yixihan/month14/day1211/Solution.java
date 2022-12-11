package com.yixihan.month14.day1211;

/**
 * 给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
 * <p>
 * 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
 * 请你返回使 nums 严格递增 的 最少 操作次数。
 * <p>
 * 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1] 。
 * 一个长度为 1 的数组是严格递增的一种特殊情况。
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以进行如下操作：
 * 1) 增加 nums[2] ，数组变为 [1,1,2] 。
 * 2) 增加 nums[1] ，数组变为 [1,2,2] 。
 * 3) 增加 nums[2] ，数组变为 [1,2,3] 。
 * <p>
 * 输入：nums = [1,5,2,4,1]
 * 输出：14
 * <p>
 * 输入：nums = [8]
 * 输出：0
 *
 * @author yixihan
 * @date 2022/12/11 12:28
 */
public class Solution {
    
    public int minOperations(int[] nums) {
        int ans = 0, mx = 0;
        for (int v : nums) {
            ans += Math.max (0, mx + 1 - v);
            mx = Math.max (mx + 1, v);
        }
        return ans;
    }
}

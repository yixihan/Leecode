package com.yixihan.month13.day1026;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。
 * 如果不存在这样的 子数组 ，返回 -1 。
 * <p>
 * 子数组 是数组中 连续 的一部分。
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * <p>
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * <p>
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 *
 * @author yixihan
 * @date 2022-10-26-9:10
 */
public class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = n + 1;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i]; // 计算前缀和
        }
        Deque<Integer> q = new ArrayDeque<> ();
        for (int i = 0; i <= n; ++i) {
            long curS = s[i];
            while (!q.isEmpty () && curS - s[q.peekFirst ()] >= k) {
                ans = Math.min (ans, i - q.pollFirst ()); // 优化一
            }
            while (!q.isEmpty () && s[q.peekLast ()] >= curS) {
                q.pollLast (); // 优化二
            }
            q.addLast (i);
        }
        return ans > n ? -1 : ans;
    }
}

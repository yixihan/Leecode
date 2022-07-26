package com.yixihan.random.day0726;

/**
 * 给你一个整数数组 nums 和两个整数k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * <p>
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * <p>
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-07-26-8:32
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs ((long) nums[i] - (long) nums[j]) <= t && Math.abs (i - j) <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}

package com.yixihan.month04.day0119;

import java.util.HashSet;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-01-19-6:39
 */
public class Solution {

    /**
     * 维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
     * 每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<> ();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains (nums[i])) {
                return true;
            }
            set.add (nums[i]);
            if (set.size () > k) {
                set.remove (nums[i - k]);
            }

        }

        return false;
    }
}

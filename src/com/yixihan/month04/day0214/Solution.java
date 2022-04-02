package com.yixihan.month04.day0214;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * @author : yixihan
 * @create : 2022-02-14-11:00
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {

//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put (num, map.getOrDefault (num, 0) + 1);
//            if (map.get (num) == 2) {
//                map.remove (num);
//            }
//        }
//
//
//        int ans = 0;
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
//            if (entry.getValue () == 1) {
//                ans = entry.getKey ();
//                break;
//            }
//        }
//
//        return ans;

        int ans = Integer.MIN_VALUE;
        Arrays.sort (nums);

        for (int i = 0; i + 1< nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                ans = nums[i];
                break;
            }
        }
        return ans == Integer.MIN_VALUE ? nums[nums.length - 1] : ans;
    }
}

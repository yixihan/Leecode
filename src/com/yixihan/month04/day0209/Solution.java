package com.yixihan.month04.day0209;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 *
 * |x| 的值定义为：
 *
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 *
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 *
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 * @author : yixihan
 * @create : 2022-02-09-8:42
 */
public class Solution {
    public int countKDifference(int[] nums, int k) {

        int count = 0;

        // 方法一
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (Math.abs (nums[i] - nums[j]) == k) {
//                    count++;
//                }
//            }
//        }

        // 方法二
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey (num + k)) {
                count += map.get (num + k);
            }

            if (map.containsKey (num - k)) {
                count += map.get (num - k);
            }

            map.put (num, map.getOrDefault (num, 0) + 1);
        }

        return count;
    }
}

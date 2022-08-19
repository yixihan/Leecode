package com.yixihan.random.day0819;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 true；否则，返回 false。
 * <p>
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * <p>
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * <p>
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 * <p>
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 *
 * @author : yixihan
 * @create : 2022-08-19-8:30
 */
public class IsPossibleDivide {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }


        Map<Integer, Integer> map = new HashMap<> ();

        for (int num : nums) {
            map.put (num, map.getOrDefault (num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get (num) == 0) {
                continue;
            }
            for (int j = 0; j < k; j++) {
                if (!map.containsKey (num + j) || map.get (num + j) == 0) {
                    return false;
                }
                map.put (num + j, map.get (num + j) - 1);
            }
        }

        return true;
    }
}

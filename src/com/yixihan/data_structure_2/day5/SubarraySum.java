package com.yixihan.data_structure_2.day5;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-03-28-8:55
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {

        int pre = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<> ();

        // 解决k = num[i]情况
        map.put(0,1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey (pre - k)) {
                res += map.get (pre - k);
            }
            map.put (pre, map.getOrDefault (pre, 0) + 1);
        }
        return res;
    }
}

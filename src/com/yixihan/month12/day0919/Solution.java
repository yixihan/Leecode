package com.yixihan.month12.day0919;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *
 * @author : yixihan
 * @create : 2022-09-19-7:44
 */
public class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<> ();
        for (int num : nums) {
            map.put (num, map.getOrDefault (num, 0) + 1);
        }

        TreeMap<Integer, TreeSet<Integer>> map1 = new TreeMap<> ();
        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
            TreeSet<Integer> set = map1.getOrDefault (entry.getValue (), new TreeSet<> ((o1, o2) -> o2 - o1));
            set.add (entry.getKey ());
            map1.put (entry.getValue (), set);
        }

        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map1.entrySet ()) {
            for (Integer val : entry.getValue ()) {
                Integer cnt = entry.getKey ();
                while (cnt-- > 0) {
                    result[index++] = val;
                }
            }
        }

        return result;
    }
}

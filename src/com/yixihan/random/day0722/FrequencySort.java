package com.yixihan.random.day0722;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
 * @create : 2022-07-22-9:12
 */
public class FrequencySort {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<> ();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<> ((o1, o2) -> {
            if (o1.getValue ().equals (o2.getValue ())) {
                return o2.getKey () - o1.getKey ();
            }
            return o1.getValue () - o2.getValue ();
        });
        int[] ans = new int[nums.length];
        int index = 0;
        int n;

        for (int num : nums) {
            map.put (num, map.getOrDefault (num, 0) + 1);
        }

        queue.addAll (map.entrySet ());

        while (!queue.isEmpty ()) {
            Map.Entry<Integer, Integer> entry = queue.poll ();
            n = entry.getValue ();
            while (n > 0) {
                ans[index++] = entry.getKey ();
                n--;
            }
        }

        return ans;
    }
}

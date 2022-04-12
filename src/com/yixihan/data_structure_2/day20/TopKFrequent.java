package com.yixihan.data_structure_2.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author : yixihan
 * @create : 2022-04-12-9:53
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<> ();

        for (int num : nums) {
            map.put (num, map.getOrDefault (num, 0) + 1);
        }

        int[] ans = new int[k];
        int index = 0;
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<> ((o1, o2) -> o2.getValue () - o1.getValue ());


        queue.addAll (map.entrySet ());

        while (index < k && !queue.isEmpty ()) {
            ans[index++] = queue.poll ().getKey ();
        }

        return ans;
    }
}

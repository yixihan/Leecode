package com.yixihan.month02.day1125;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author : yixihan
 * @create : 2021-11-25-12:32
 */
public class TopKFrequent {

    /**
     * 先将值放入一个 map 中, 在将其 entry 取出来放入 list 排序
     */
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int num;
        int count;
        List<int[]> list = new ArrayList<>();

        for (int value : nums) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            num = entry.getKey();
            count = entry.getValue();
            list.add(new int[]{num, count});
        }

        list.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));

        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }

        return res;
    }
}

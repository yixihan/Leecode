package com.yixihan.month02.day1120;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yixihan
 * @create : 2021-11-20-0:57
 */
public class FindLhs {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);
        int res = 0;


        for (int num : nums) {
            map.put(num,map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {

            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }

        return res;
    }



}

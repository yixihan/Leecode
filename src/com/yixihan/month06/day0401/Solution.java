package com.yixihan.month06.day0401;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，
 * 都有 arr[2 * i + 1] = 2 * arr[2 * i] 时，返回 true；否则，返回 false。
 * <p>
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * <p>
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 *
 * @author : yixihan
 * @create : 2022-04-01-12:56
 */
public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort (arr);
        Map<Integer, Integer> map = new HashMap<> ();

        for (int val : arr) {
            if (val < 0) {
                if (map.containsKey (2 * val) && map.get (2 * val) != 0) {
                    map.put (2 * val, map.get (2 * val) - 1);
                } else {
                    map.put (val, map.getOrDefault (val, 0) + 1);
                }
            } else {
                if (map.containsKey (val) && map.get (val) != 0) {
                    map.put (val, map.get (val) - 1);
                } else {
                    map.put (2 * val, map.getOrDefault (2 * val, 0) + 1);
                }
            }

        }
        System.out.println (map);

        for (Integer val : map.values ()) {
            if (val != 0) {
                return false;
            }
        }


        return true;
    }
}

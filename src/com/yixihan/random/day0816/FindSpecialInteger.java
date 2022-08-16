package com.yixihan.random.day0816;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *
 * @author : yixihan
 * @create : 2022-08-16-9:25
 */
public class FindSpecialInteger {

    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<> ();
        int ans = 0;

        for (int val : arr) {
            map.put (val, map.getOrDefault (val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
            if (entry.getValue () > arr.length / 4) {
                ans = entry.getKey ();
                break;
            }
        }

        return ans;
    }
}

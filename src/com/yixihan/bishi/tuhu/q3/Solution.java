package com.yixihan.bishi.tuhu.q3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author : yixihan
 * @create : 2022-08-31-18:52
 */
public class Solution {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1
     *
     * @param nums int整型一维数组
     * @param k    int整型
     * @return int整型
     */
    public int minimumIncompatibility(int[] nums, int k) {
        // write code here
        int len = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<> ((o1, o2) -> o2 - o1);

        for (int num : nums) {
            map.put (num, map.getOrDefault (num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
            if (entry.getValue () > len / k) {
                return -1;
            }
        }



        return map.firstKey ();
    }
}


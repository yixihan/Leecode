package com.yixihan.random.day0805;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * @author : yixihan
 * @create : 2022-08-05-9:07
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<> ();

        for (int num : nums) {
            map.put (num, map.getOrDefault (num, 0) + 1);
        }

        List<Integer> list = new ArrayList<> (map.keySet ());
        Collections.sort (list);
        int ans = 0;
        int cnt = 1;
        for (int i = 1; i < list.size (); i++) {
            if (list.get (i) - list.get (i - 1) == 1) {
                cnt++;
            } else {
                ans = Math.max (cnt, ans);
                cnt = 1;
            }
        }

        return list.size () == 0 ? 0 : Math.max (ans, cnt);
    }
}

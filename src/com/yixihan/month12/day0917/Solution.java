package com.yixihan.month12.day0917;

import java.util.*;

/**
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * <p>
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * <p>
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 * <p>
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 *
 * @author : yixihan
 * @create : 2022-09-17-9:11
 */
public class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, TreeSet<Integer>> map = new HashMap<> ();
        char[] arr = s.toCharArray ();
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            TreeSet<Integer> set = map.getOrDefault (arr[i], new TreeSet<> ());
            set.add (i);
            map.put (arr[i], set);
        }

        for (Map.Entry<Character, TreeSet<Integer>> entry : map.entrySet ()) {
            if (entry.getValue ().size () > 1) {
                maxLen = Math.max (maxLen, entry.getValue ().last () - entry.getValue ().first () - 1);
            }
        }

        return maxLen;
    }
}

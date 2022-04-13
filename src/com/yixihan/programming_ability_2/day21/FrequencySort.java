package com.yixihan.programming_ability_2.day21;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * <p>
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * <p>
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 * @author : yixihan
 * @create : 2022-04-13-13:10
 */
public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<> (52);

        for (char c : s.toCharArray ()) {
            map.put (c, map.getOrDefault (c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<> ((o1, o2) -> o2.getValue () - o1.getValue ());
        queue.addAll (map.entrySet ());
        StringBuilder sb = new StringBuilder (s.length ());
        while (!queue.isEmpty ()) {
            Map.Entry<Character, Integer> entry = queue.poll ();
            Integer value = entry.getValue ();
            while (value-- > 0) {
                sb.append (entry.getKey ());
            }
        }

        return sb.toString ();
    }
}

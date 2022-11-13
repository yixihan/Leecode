package com.yixihan.month13.day1113;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * <p>
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。
 * 更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * <p>
 * 返回 满足这个性质的 s 的任意排列 。
 * <p>
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * <p>
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 *
 * @author yixihan
 * @date 2022/11/13 18:02
 */
public class Solution {

    Map<Character, Integer> map;

    public String customSortString(String order, String s) {
        initSortMap (order);
        return sortStr (s);
    }

    private String sortStr (String s) {
        Character[] arr = new Character[s.length ()];
        int index = 0;
        for (char c : s.toCharArray ()) {
            arr[index++] = c;
        }


        Arrays.sort (arr, (o1, o2) -> map.getOrDefault (o1, -1) - map.getOrDefault (o2, -1));
        StringBuilder sb = new StringBuilder ();
        for (char c : arr) {
            sb.append (c);
        }
        return sb.toString ();
    }

    private void initSortMap (String order) {
        map = new HashMap<> (order.length ());
        int index = 0;

        for (char c : order.toCharArray ()) {
            map.put (c, index++);
        }
    }
}

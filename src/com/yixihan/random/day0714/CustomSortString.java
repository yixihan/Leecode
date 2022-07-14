package com.yixihan.random.day0714;

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
 * @author : yixihan
 * @create : 2022-07-14-9:27
 */
public class CustomSortString {

    public String customSortString(String order, String s) {

        Map<Character, Integer> orderMap = new HashMap<> ();
        Map<Character, Integer> map = new HashMap<> ();
        char[] orderChars = order.toCharArray ();


        for (char c : orderChars) {
            orderMap.put (c, 0);
        }

        for (char c : s.toCharArray ()) {
            if (orderMap.containsKey (c)) {
                orderMap.put (c, orderMap.get (c) + 1);
            } else {
                map.put (c, map.getOrDefault (c, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder ();
        int index;
        for (char c : orderChars) {
            index = orderMap.get (c);
            while (index > 0) {
                sb.append (c);
                index--;
            }

        }
        for (Map.Entry<Character, Integer> entry : map.entrySet ()) {
            index = entry.getValue ();
            while (index > 0) {
                sb.append (entry.getKey ());
                index--;
            }
        }

        return sb.toString ();
    }
}

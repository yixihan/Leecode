package com.yixihan.data_structure_1.day6;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 * @author : yixihan
 * @create : 2022-03-15-11:52
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {

        // 方式一 : set + indexOf
        Set<Character> set = new HashSet<> ();

        for (int i = 0; i < s.length (); i++) {
            char val = s.charAt (i);
            if (! set.contains (val) && s.indexOf (String.valueOf (val), i + 1) < 0) {
                return i;
            } else {
                set.add (val);
            }
        }

        return -1;

        // 方法二 : Map
//        Map<Character, Integer> map = new HashMap<> ();
//
//        for (int i = 0; i < s.length (); i++) {
//            map.put (s.charAt (i), map.getOrDefault (s.charAt (i), 0) + 1);
//        }
//
//        for (int i = 0; i < s.length (); i++) {
//            if (map.get (s.charAt (i)) == 1) {
//                return i;
//            }
//        }
//
//        return -1;

        // 方法三 : 活用 String api
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
//                return i;
//            }
//        }
//        return -1;

    }
}

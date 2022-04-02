package com.yixihan.offer.day05;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *
 * @author : yixihan
 * @create : 2022-02-25-13:53
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {

        // 方法一 : 哈希表
//        char ans = ' ';
//        Map<Character, Integer> map = new LinkedHashMap<> ();
//
//        for (int i = 0; i < s.length (); i++) {
//            map.put (s.charAt (i), map.getOrDefault (s.charAt (i), 0) + 1);
//        }
//
//        for (Map.Entry<Character, Integer> entry : map.entrySet ()) {
//            if (entry.getValue () == 1) {
//                ans = entry.getKey ();
//                break;
//            }
//        }
//
//        return ans;

        char ans = ' ';
        boolean[] letters = new boolean[26];
        for (int i = 0; i < s.length (); i++) {
            char arr = s.charAt (i);
            if (letters[arr - 'a']) {
                continue;
            }
            int index = s.indexOf (arr, i + 1);
            if (index < 0) {
                ans = arr;
                break;
            } else {
                letters[arr - 'a'] = true;
            }
        }

        return ans;
    }
}

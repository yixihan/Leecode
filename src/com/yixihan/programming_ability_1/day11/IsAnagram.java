package com.yixihan.programming_ability_1.day11;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @author : yixihan
 * @create : 2022-03-21-11:10
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {

        // 方法一 : API 大法
//        char[] chars = s.toCharArray ();
//        char[] chart = t.toCharArray ();
//        Arrays.sort (chars);
//        Arrays.sort (chart);
//
//        return Arrays.equals (chars, chart);
        // 方法二 : 字母数组对比
        if (s.length () != t.length ()) {
            return false;
        }

        int n = s.length ();
        int[] letters = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < n; i++) {
            letters[sChars[i] - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (--letters[tChars[i] - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}

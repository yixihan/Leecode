package com.yixihan.data_structure_1.day6;

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
 * @create : 2022-03-15-13:05
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {

        // 方法一 : 哈希表, 不予实现

        // 方法二 : 单词数组
//        if (s.length () != t.length ()) {
//            return false;
//        }
//
//        int n = s.length ();
//        int[] letters = new int[26];
//
//        for (int i = 0; i < n; i++) {
//            letters[s.charAt (i) - 'a']++;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (--letters[t.charAt (i) - 'a'] < 0) {
//                return false;
//            }
//        }
//
//        return true;

        // 方法二 : 优化版
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

        // 方法三 : 转换为数组, 排序后比较
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//
//        return Arrays.equals(sChars, tChars);

        // 方法四 : 一行解决版
//        return Arrays.equals (s.chars ().sorted ().toArray (), t.chars ().sorted ().toArray ());
    }
}

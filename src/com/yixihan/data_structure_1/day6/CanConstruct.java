package com.yixihan.data_structure_1.day6;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-03-15-12:58
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {

        // 方法一 : 哈希表
//        if (ransomNote.length () > magazine.length ()) {
//            return false;
//        }
//
//        int n = ransomNote.length ();
//        int m = magazine.length ();
//        Map<Character, Integer> map = new HashMap<> (m);
//
//        for (int i = 0; i < m; i++) {
//            map.put (magazine.charAt (i), map.getOrDefault (magazine.charAt (i), 0) + 1);
//        }
//
//        for (int i = 0; i < n; i++) {
//            Integer val = map.get (ransomNote.charAt (i));
//            if (val == null || val <= 0) {
//                return false;
//            } else {
//                map.put (ransomNote.charAt (i), val - 1);
//            }
//        }
//
//        return true;

        // 方法二 : 单词数组
        if (ransomNote.length () > magazine.length ()) {
            return false;
        }

        int n = ransomNote.length ();
        int m = magazine.length ();
        int[] letters = new int[26];

        for (int i = 0; i < m; i++) {
            letters[magazine.charAt (i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (--letters[ransomNote.charAt (i) - 'a'] < 0) {
                return false;
            }
        }

        return true;

    }
}

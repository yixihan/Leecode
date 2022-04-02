package com.yixihan.programming_ability_1.day8;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * @author : yixihan
 * @create : 2022-03-18-14:37
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];

        for (char c : s.toCharArray ()) {
            letters[c - 'a']++;
        }

        for (char c : t.toCharArray ()) {
            letters[c - 'a']--;

            if (letters[c - 'a'] < 0) {
                return c;
            }
        }

        return 0;
    }
}

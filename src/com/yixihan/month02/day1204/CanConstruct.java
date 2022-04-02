package com.yixihan.month02.day1204;

/**
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
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
 * @create : 2021-12-04-15:29
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] letter = new int[26];

        for (int i = 0; i < magazine.length (); i++) {
            letter[magazine.charAt (i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length (); i++) {
            int val = --letter[ransomNote.charAt (i) - 'a'];
            if (val < 0) {
                return false;
            }
        }

        return true;
    }
}

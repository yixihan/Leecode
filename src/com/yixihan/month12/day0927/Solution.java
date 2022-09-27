package com.yixihan.month12.day0927;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * @author yixihan
 * @date 2022-09-27-9:04
 */
public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        int[] letter1 = getLetters (s1);
        int[] letter2 = getLetters (s2);

        return Arrays.equals (letter1, letter2);
    }

    private int[] getLetters (String s) {
        int[] letters = new int[52];
        for (char c : s.toCharArray ()) {
            if (c >= 'a' && c <= 'z') {
                letters[c - 'a' + 26]++;
            } else if (c >= 'A' && c <= 'Z') {
                letters[c - 'A']++;
            }
        }

        return letters;
    }
}

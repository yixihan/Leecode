package com.yixihan.month13.day1108;

/**
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *
 * @author yixihan
 * @date 2022/11/8 9:02
 */
public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = getChars (allowed);
        int ans = 0;

        for (String word : words) {
            if (equals (allow, getChars (word))) {
                ans++;
            }
        }

        return ans;
    }

    private boolean[] getChars(String str) {
        boolean[] letters = new boolean[26];

        for (char c : str.toCharArray ()) {
            letters[c - 'a'] = true;
        }

        return letters;
    }

    private boolean equals(boolean[] arr1, boolean[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] && !arr1[i]) {
                return false;
            }
        }

        return true;
    }
}

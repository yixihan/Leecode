package com.yixihan.random.day0805;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 * @author : yixihan
 * @create : 2022-08-05-15:08
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length ();
        int len2 = text2.length ();
        char[] str1 = text1.toCharArray ();
        char[] str2 = text2.toCharArray ();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max (dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}

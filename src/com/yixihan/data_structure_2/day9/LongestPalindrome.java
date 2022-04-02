package com.yixihan.data_structure_2.day9;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author : yixihan
 * @create : 2022-04-01-14:24
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray ();
        int n = arr.length;
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        int maxLength = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (arr[i] == arr[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring (left, right + 1);
    }
}

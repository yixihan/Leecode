package com.yixihan.month09.day0627;

/**
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 * s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。
 * "aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 * <p>
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * <p>
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 *
 * @author : yixihan
 * @create : 2022-06-27-12:10
 */
public class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length, ans = -1;
        for (int i = 0; i < n; i++) {
            if (strs[i].length () <= ans) continue;
            boolean ok = true;
            for (int j = 0; j < n && ok; j++) {
                if (i == j) continue;
                if (check (strs[i], strs[j])) ok = false;
            }
            if (ok) ans = strs[i].length ();
        }
        return ans;
    }

    boolean check(String s1, String s2) {
        int n = s1.length (), m = s2.length ();
        if (m < n) return false;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = s1.charAt (i - 1) == s2.charAt (j - 1) ? f[i - 1][j - 1] + 1 : f[i - 1][j - 1];
                f[i][j] = Math.max (f[i][j], f[i - 1][j]);
                f[i][j] = Math.max (f[i][j], f[i][j - 1]);
                if (f[i][j] == n) return true;
            }
        }
        return false;
    }
}

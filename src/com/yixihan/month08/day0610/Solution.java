package com.yixihan.month08.day0610;

/**
 * 给定一个字符串 s，返回 s 中不同的非空「回文子序列」个数 。
 * <p>
 * 通过从 s 中删除 0 个或多个字符来获得子序列。
 * <p>
 * 如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。
 * <p>
 * 如果有某个 i , 满足 ai != bi ，则两个序列 a1, a2, ... 和 b1, b2, ... 不同。
 * <p>
 * 注意：
 * <p>
 * 结果可能很大，你需要对 109 + 7 取模 。
 * <p>
 * 输入：s = 'bccb'
 * 输出：6
 * 解释：6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
 * 注意：'bcb' 虽然出现两次但仅计数一次。
 * <p>
 * 输入：s = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * 输出：104860361
 * 解释：共有 3104860382 个不同的非空回文子序列，104860361 对 109 + 7 取模后的值。
 *
 * @author : yixihan
 * @create : 2022-06-10-16:52
 */
public class Solution {
    int mod = (int) 1e9 + 7;

    public int countPalindromicSubsequences(String s) {

        char c[] = s.toCharArray ();

        long ans[][] = new long[c.length][c.length];
        for (int i = 0; i < c.length; i++) {
            ans[i][i] = 1;
        }

        for (int d = 1; d < c.length; d++) {
            for (int i = 0; i < c.length - d; i++) {
                if (c[i] == c[i + d]) {
                    int l = i + 1, r = i + d - 1;
                    while (c[l] != c[i]) {
                        l++;
                    }
                    while (c[r] != c[i]) {
                        r--;
                    }
                    if (l > r) {
                        ans[i][i + d] = ans[i][i + d] = ans[i + 1][i + d - 1] * 2 + 2;
                    }//说明这俩字母之间没有相同字母
                    else if (l == r) {
                        ans[i][i + d] = ans[i + 1][i + d - 1] * 2 + 1;
                    }//中间只要一个相同字母
                    else {
                        ans[i][i + d] = ans[i + 1][i + d - 1] * 2 - ans[l + 1][r - 1] + mod;
                    }
                } else {
                    ans[i][i + d] = ans[i][i + d - 1] + ans[i + 1][i + d] - ans[i + 1][i + d - 1] + mod;
                }
                ans[i][i + d] %= mod;
            }
        }
        return (int) ans[0][c.length - 1];
    }
}

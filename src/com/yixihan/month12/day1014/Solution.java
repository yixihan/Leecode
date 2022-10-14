package com.yixihan.month12.day1014;

import java.util.Arrays;

/**
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 * <p>
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 * <p>
 * 输入：s = "abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * <p>
 * 输入：s = "aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * <p>
 * 输入：s = "aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 *
 * @author yixihan
 * @date 2022-10-14-9:06
 */
public class Solution {

    private final long MOD = (long) 1e9 + 7;

    public int distinctSubseqII(String s) {
        int n = s.length ();
        long[][] f = new long[n][26];
        f[0][s.charAt (0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1].clone ();
            f[i][s.charAt (i) - 'a'] = (1 + Arrays.stream (f[i - 1]).sum ()) % MOD;
        }
        return (int) (Arrays.stream (f[n - 1]).sum () % MOD);
    }
}

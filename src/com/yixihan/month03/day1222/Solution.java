package com.yixihan.month03.day1222;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 *
 * 输入：a = "a", b = "aa"
 * 输出：2
 *
 * 输入：a = "a", b = "a"
 * 输出：1
 *
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 *
 * @author : yixihan
 * @create : 2021-12-23-0:40
 */
public class Solution {

    // 字符串哈希
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int result = 0;

        while (sb.length () < b.length () && ++result > 0) {
            sb.append (a);
        }
        sb.append (a);

        int idx = strHash(sb.toString(), b);
        if (idx == -1) {
            return -1;
        }
        return idx + b.length() > a.length() * result ? result + 1 : result;
        
    }

    int strHash(String ss, String b) {
        int P = 131;
        int n = ss.length ();
        int m = b.length ();
        String str = ss + b;
        int len = str.length ();
        int[] h = new int[len + 10];
        int[] p = new int[len + 10];
        p[0] = 1;

        for (int i = 0; i < len; i++) {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + str.charAt (i);
        }

        int l = len - m + 1;
        // b 的哈希值
        int target = h[len] - h[l - 1] * p[len - l + 1];

        for (int i = 1; i <= n; i++) {
            int j = i + m - 1;
            // 子串哈希值
            int cur = h[j] - h[i - 1] * p[j - i + 1];
            if (cur == target) {
                return i - 1;
            }
        }
        return -1;
    }
}

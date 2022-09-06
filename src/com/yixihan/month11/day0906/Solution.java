package com.yixihan.month11.day0906;

import java.util.Arrays;

/**
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 * <p>
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 * <p>
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 * <p>
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 * <p>
 * 输入: s = "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 * 其中，每一个子串都由独特字符构成。
 * 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 * <p>
 * 输入: s = "ABA"
 * 输出: 8
 * 解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
 * <p>
 * 输入：s = "LEETCODE"
 * 输出：92
 *
 * @author : yixihan
 * @create : 2022-09-06-13:11
 */
public class Solution {

    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray ();
        int n = cs.length;
        int ans = 0;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] cnts = new int[26];

        Arrays.fill (cnts, -1);
        for (int i = 0; i < n; i++) {
            int u = cs[i] - 'A';
            l[i] = cnts[u];
            cnts[u] = i;
        }

        Arrays.fill (cnts, n);
        for (int i = n - 1; i >= 0; i--) {
            int u = cs[i] - 'A';
            r[i] = cnts[u];
            cnts[u] = i;
        }

        for (int i = 0; i < n; i++) {
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;
    }
}

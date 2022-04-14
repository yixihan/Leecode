package com.yixihan.zhaoshang.day1;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author : yixihan
 * @create : 2022-04-14-16:56
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s.length () <= 1) {
            return s.length ();
        }

        int start = 0;
        int ans = 1;
        char[] arr = s.toCharArray ();
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = start; j < i; j++) {
                if (arr[i] == arr[j]) {
                    start = j + 1;
                    break;
                }
            }
            ans = Math.max (ans, i - start + 1);
        }

        return ans;

    }
}

package com.yixihan.offer.day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author : yixihan
 * @create : 2022-03-02-13:16
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        Set<Character> set = new HashSet<> ();

        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            maxSize = Math.max(maxSize, r - l + 1);
        }

        return maxSize;
    }
}

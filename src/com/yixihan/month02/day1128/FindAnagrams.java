package com.yixihan.month02.day1128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * @author : yixihan
 * @create : 2021-11-29-13:55
 */
public class FindAnagrams {


    /**
     * 暴力解法
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int length = p.length();
        String temp;

        char[] array = p.toCharArray();
        Arrays.sort(array);
        p = new String(array);

        for (int i = 0; i <= s.length() - length; i++) {
            temp = s.substring(i, i + length);
            char[] arr1 = temp.toCharArray();
            Arrays.sort(arr1);
            String val = new String(arr1);

            if (val.equals(p)) {
                result.add(i);
            }
        }


        return result;
    }

    /**
     * 统计字母数量
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i = 0; i < m; i++) {
            c2[p.charAt(i) - 'a']++;
        }

        for (int l = 0, r = 0; r < n; r++) {

            c1[s.charAt(r) - 'a']++;
            if (r - l + 1 > m) {
                c1[s.charAt(l++) - 'a']--;
            }
            if (check(c1, c2)) {
                result.add(l);
            }
        }
        return result;
    }

    boolean check(int[] c1, int[] c2) {

        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }

        return true;
    }
}

package com.yixihan.programming_ability_2.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * @author : yixihan
 * @create : 2022-04-03-14:46
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // 方法一 : 暴力法
        //        char[] arr1 = s.toCharArray ();
        //        char[] arr2 = p.toCharArray ();
        //        int n1 = arr1.length;
        //        int n2 = arr2.length;
        //        List<Integer> ans = new ArrayList<>();
        //        Arrays.sort (arr2);
        //        String target = new String (arr2);
        //
        //        for (int i = 0; i <= n1 - n2; i++) {
        //            String val = new String (arr1, i, n2);
        //            System.out.println (val);
        //            char[] tmp = val.toCharArray ();
        //            Arrays.sort (tmp);
        //
        //            if (new String (tmp).equals (target)) {
        //                ans.add (i);
        //            }
        //        }
        //
        //        return ans;

        // 方法二 :
        List<Integer> result = new ArrayList<> ();
        char[] arr1 = s.toCharArray ();
        char[] arr2 = p.toCharArray ();
        int n = arr1.length;
        int m = arr2.length;
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (char c : arr2) {
            c2[c - 'a']++;
        }

        for (int l = 0, r = 0; r < n; r++) {

            c1[arr1[r] - 'a']++;
            if (r - l + 1 > m) {
                c1[arr1[l++] - 'a']--;
            }
            if (Arrays.equals (c1, c2)) {
                result.add (l);
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

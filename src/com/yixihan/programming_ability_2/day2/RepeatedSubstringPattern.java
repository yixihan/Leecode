package com.yixihan.programming_ability_2.day2;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * <p>
 * 输入: s = "aba"
 * 输出: false
 * <p>
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 *
 * @author : yixihan
 * @create : 2022-03-24-10:49
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        str = str.substring (1, str.length () - 1);
        return str.contains (s);

    }
}

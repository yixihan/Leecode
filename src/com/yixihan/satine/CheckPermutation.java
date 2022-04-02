package com.yixihan.satine;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * @author : yixihan
 * @create : 2022-03-03-17:14
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {

        s1 = sort (s1);
        s2 = sort (s2);

        return s1.equals (s2);
    }

    private String sort (String str) {
        char[] chars = str.toCharArray ();
        Arrays.sort (chars);
        return new String (chars);
    }
}

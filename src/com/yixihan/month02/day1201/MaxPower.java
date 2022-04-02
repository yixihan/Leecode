package com.yixihan.month02.day1201;

/**
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 *
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 *
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 *
 * 输入：s = "triplepillooooow"
 * 输出：5
 *
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 *
 * @author : yixihan
 * @create : 2021-12-01-11:31
 */
public class MaxPower {
    
    public int maxPower (String s) {

        int result = 0;
        int count = 1;

        for (int i = 1; i < s.length (); i++) {

            if (s.charAt (i) == s.charAt (i - 1)) {
                count++;
            } else {
                result = Math.max (count, result);
                count = 1;
            }
        }

        return Math.max (count, result);
    }
}

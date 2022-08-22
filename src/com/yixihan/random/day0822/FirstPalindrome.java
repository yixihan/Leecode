package com.yixihan.random.day0822;

/**
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 *
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 *
 * 输入：words = ["abc","car","ada","racecar","cool"]
 * 输出："ada"
 * 解释：第一个回文字符串是 "ada" 。
 * 注意，"racecar" 也是回文字符串，但它不是第一个。
 *
 * 输入：words = ["notapalindrome","racecar"]
 * 输出："racecar"
 * 解释：第一个也是唯一一个回文字符串是 "racecar" 。
 *
 * 输入：words = ["def","ghi"]
 * 输出：""
 * 解释：不存在回文字符串，所以返回一个空字符串。
 *
 * @author : yixihan
 * @create : 2022-08-22-8:48
 */
public class FirstPalindrome {

    public String firstPalindrome(String[] words) {
        String ans = "";

        for (String word : words) {
            if (helper (word)) {
                return word;
            }
        }

        return ans;
    }


    private boolean helper (String word) {
        char[] arr = word.toCharArray ();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}

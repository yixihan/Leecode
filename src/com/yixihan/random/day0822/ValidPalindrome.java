package com.yixihan.random.day0822;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * <p>
 * 输入: s = "abc"
 * 输出: false
 *
 * @author : yixihan
 * @create : 2022-08-22-8:39
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray ();
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if (arr[l] != arr[r]) {
               return verify (arr, l + 1, r) || verify (arr, l, r - 1);
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean verify(char[] arr, int l, int r) {
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

/*
"eeccccbebaeeabebccceea"
     1           1
 */

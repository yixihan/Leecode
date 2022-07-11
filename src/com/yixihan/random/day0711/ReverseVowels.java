package com.yixihan.random.day0711;

import java.util.Arrays;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *
 * @author : yixihan
 * @create : 2022-07-11-8:46
 */
public class ReverseVowels {

    char[] a = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray ();
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        System.out.println (arr[1]);
        System.out.println (Arrays.binarySearch (a, arr[1]));

        while (l < r) {
            while (l < r && Arrays.binarySearch (a, arr[l]) < 0) {
                l++;
            }

            while (l < r && Arrays.binarySearch (a, arr[r]) < 0) {
                r--;
            }

            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }

        return new String (arr);
    }
}

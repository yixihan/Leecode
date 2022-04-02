package com.yixihan.data_structure_2.day6;

import java.util.Arrays;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 输入:s = "a"
 * 输入:1
 * <p>
 * 输入:s = "bb"
 * 输入: 2
 *
 * @author : yixihan
 * @create : 2022-03-29-9:00
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] letters = new int[52];
        char[] arr = s.toCharArray ();
        int n = arr.length;

        for (char val : arr) {
            if (val >= 'a' && val <= 'z') {
                letters[val - 'a' + 26]++;
            } else {
                letters[val - 'A']++;
            }
        }

        System.out.println (Arrays.toString (letters));
        int ans = 0;
        boolean flag = true;
        for (int letter : letters) {
            ans += letter / 2 * 2;
            if (flag && letter % 2 != 0) {
                flag = false;
                ans += 1;
            }
        }

        return ans;
    }
}

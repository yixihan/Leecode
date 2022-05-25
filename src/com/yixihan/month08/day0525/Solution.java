package com.yixihan.month08.day0525;

/**
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 * <p>
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." .
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。
 * <p>
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * <p>
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * <p>
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 *
 * @author : yixihan
 * @create : 2022-05-25-8:33
 */
public class Solution {

    public int findSubstringInWraproundString(String p) {
        char[] arr = p.toCharArray ();
        int n = arr.length;

        if (n < 1) {
            return 0;
        }

        int ans = 0;
        int[] letters = new int[26];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && (arr[i] - arr[i - 1] == 1 || arr[i - 1] - arr[i] == 25)) {
                maxLen++;
            } else {
                maxLen = 1;
            }

            letters[arr[i] - 'a'] = Math.max (letters[arr[i] - 'a'], maxLen);
        }

        for (int tmp : letters) {
            ans += tmp;
        }

        return ans;
    }
}

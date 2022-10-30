package com.yixihan.month13.day1030;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 *
 * @author yixihan
 * @date 2022-10-30-12:11
 */
public class Solution {

    private char[] arr;
    private final List<String> ans = new ArrayList<> ();

    public List<String> letterCasePermutation(String s) {
        arr = s.toCharArray ();
        dfs (0, new StringBuilder ());
        return ans;
    }

    private void dfs (int index, StringBuilder sb) {
        if (index >= arr.length) {
            ans.add (sb.toString ());
            return;
        }

        dfs (index + 1, new StringBuilder (sb).append (arr[index]));

        if (arr[index] >= 'a' && arr[index] <= 'z') {
            dfs (index + 1, new StringBuilder (sb).append ((char) (arr[index] - 32)));
        } else if (arr[index] >= 'A' && arr[index] <= 'Z') {
            dfs (index + 1, new StringBuilder (sb).append ((char) (arr[index] + 32)));
        }
    }
}

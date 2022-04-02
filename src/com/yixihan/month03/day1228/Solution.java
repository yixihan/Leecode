package com.yixihan.month03.day1228;

import java.util.*;

/**
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 *
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 *
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 *      "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 *      "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 *
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 *
 * @author : yixihan
 * @create : 2021-12-28-10:43
 */
public class Solution {

    Set<Long> set = new HashSet<> ();
    private static final int P = 131;
    private static final int OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String word : words) {
            long hash = 0;
            for (char c : word.toCharArray ()) {
                hash = hash * P + (c - 'a') + OFFSET;
            }
            set.add (hash);
        }
        List<String> ans = new ArrayList<> ();
        for (String s : words) {
            if (check (s)) {
                ans.add (s);
            }
        }
        return ans;
    }

    private boolean check(String s) {
        int n = s.length ();
        int[] f = new int[n + 1];
        Arrays.fill (f, -1);

        f[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (f[i] == -1) {
                continue;
            }
            long cur = 0;
            for (int j = i + 1; j <= n; j++) {
                cur = cur * P + (s.charAt (j - 1) - 'a') + OFFSET;
                if (set.contains (cur)) {
                    f[j] = Math.max (f[j], f[i] + 1);
                }
            }
            if (f[n] > 1) {
                return true;
            }
        }
        return false;
    }

}

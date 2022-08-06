package com.yixihan.month10.day0806;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * <p>
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * <p>
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 * <p>
 * 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * <p>
 * 输入：words = ["blue","green","bu"]
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-08-06-8:37
 */
public class Solution {

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<> ();
        Arrays.sort (words, Comparator.comparingInt (String::length));
        int len = words.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (words[j].contains (words[i])) {
                    set.add (words[i]);
                }
            }
        }


        return new ArrayList<> (set);
    }
}

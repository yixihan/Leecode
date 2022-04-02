package com.yixihan.month06.day0317;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个字符串数组words 组成的一本英语词典。
 * 返回words 中最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 *
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 *
 *
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 *
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
 *
 * @author : yixihan
 * @create : 2022-03-17-11:57
 */
public class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<> ();
        String ans = "";

        Arrays.sort (words);

        for (String word : words) {
            if (word.length() == 1 || set.contains (word.substring (0, word.length () - 1))) {
                ans = word.length() > ans.length() ? word : ans;
                set.add (word);
            }
        }

        return ans;
    }
}

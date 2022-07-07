package com.yixihan.random.day0707;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * 输入
 * inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 *
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *
 * @author : yixihan
 * @create : 2022-07-07-8:32
 */
public class MagicDictionary {

    Map<Integer, PriorityQueue<String>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {

        for (String word : dictionary) {
            PriorityQueue<String> queue = map.getOrDefault (word.length (), new PriorityQueue<> (String::compareTo));
            queue.add (word);
            map.put (word.length (), queue);
        }
    }

    public boolean search(String searchWord) {
        if (!map.containsKey (searchWord.length ())) {
            return false;
        }

        char[] arr = searchWord.toCharArray ();
        for (String s : map.get (searchWord.length ())) {
            char[] dict = s.toCharArray ();
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != dict[i]) {
                    cnt++;
                }
                if (cnt > 1) {
                    break;
                }
            }
            if (cnt == 1) {
                return true;
            }
        }

        return false;
    }
}

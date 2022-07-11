package com.yixihan.month09.day0711;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *
 * @author : yixihan
 * @create : 2022-07-11-8:01
 */
public class MagicDictionary {

    Map<Integer, List<String>> map = new HashMap<> ();

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            int len = word.length ();
            List<String> list = map.getOrDefault (len, new ArrayList<> ());
            list.add (word);
            map.put (len, list);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length ();
        if (!map.containsKey (len)) {
            return false;
        }

        char[] searchArr = searchWord.toCharArray ();
        for (String word : map.get (len)) {
            char[] arr = word.toCharArray ();
            int cnt = 0;

            for (int i = 0; i < len; i++) {
                if (arr[i] != searchArr[i]) {
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

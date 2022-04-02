package com.yixihan.month04.day0130;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 *
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 *
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 *
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 *
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 *
 * @author : yixihan
 * @create : 2022-01-30-9:30
 */
public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        String[] str = (s1 + " " + s2).split (" ");
        Map<String, Integer> map = new HashMap<>();

        for (String val : str) {
            map.put (val, map.getOrDefault (val, 0) + 1);
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet ()) {
            if (entry.getValue () == 1) {
                list.add (entry.getKey ());
            }
        }
        String[] result = new String[list.size ()];
        return list.toArray (result);
    }
}

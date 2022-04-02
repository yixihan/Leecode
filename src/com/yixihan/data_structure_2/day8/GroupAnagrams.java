package com.yixihan.data_structure_2.day8;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * @author : yixihan
 * @create : 2022-03-31-0:35
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<> ();
        Map<String, List<String>> map = new HashMap<> ();

        for (String str : strs) {
            char[] arr = str.toCharArray ();
            Arrays.sort (arr);
            String val = new String (arr);
            if (map.containsKey (val)) {
                List<String> list = map.get (val);
                list.add (str);
                continue;
            }
            List<String> list = new ArrayList<> ();
            list.add (str);
            map.put (val, list);
            ans.add (list);
        }

        return ans;
    }
}

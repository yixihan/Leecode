package com.yixihan.data_structure_2.day7;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * @author : yixihan
 * @create : 2022-03-30-8:30
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] splits = s.split (" ");
        char[] arr = pattern.toCharArray ();
        int n = splits.length;
        int p = arr.length;

        if (p != n) {
            return false;
        }

        Map<Character, String> map = new HashMap<> ();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey (arr[i])) {
                if (map.containsValue (splits[i])) {
                    return false;
                }
                map.put (arr[i], splits[i]);
            } else {
                if (!map.get (arr[i]).equals (splits[i])) {
                    return false;
                }
            }
        }

        // for (Map.Entry<Character, String> entry : map.entrySet ()) {
        //     System.out.println (entry);
        // }

        return true;
    }
}

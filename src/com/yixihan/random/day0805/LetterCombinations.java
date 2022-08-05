package com.yixihan.random.day0805;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * @author : yixihan
 * @create : 2022-08-05-13:59
 */
public class LetterCombinations {

    char[][] letters = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        if ("".equals (digits)) {
            return new ArrayList<> ();
        }

        Map<Integer, Set<String>> map = new HashMap<>();
        int index = 0;
        for (char c : digits.toCharArray ()) {
            char[] letter = letters[c - '0' - 2];
            Set<String> set = new HashSet<> ();
            if (!map.containsKey (index - 1)) {
                for (char value : letter) {
                    set.add (String.valueOf (value));
                }
            } else {
                Set<String> tmp = map.get (index - 1);
                for (String str : tmp) {
                    for (char value : letter) {
                        set.add (str + value);
                    }
                }
            }
            map.put (index++, set);

        }

        return new ArrayList<> (map.get (index - 1));

    }
}

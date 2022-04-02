package com.yixihan.satine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author : yixihan
 * @create : 2022-03-04-13:31
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<> ();

        for (int i = 0; i < s.length (); i++) {
            map.put (s.charAt (i), map.getOrDefault (s.charAt (i), 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet ()) {
            if (entry.getValue () % 2 != 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}

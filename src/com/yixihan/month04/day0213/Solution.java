package com.yixihan.month04.day0213;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * <p>
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-02-13-10:39
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<> ();

        for (int i = 0; i < text.length (); i++) {
            map.put (text.charAt (i), map.getOrDefault (text.charAt (i), 0) + 1);
        }

        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        if (map.containsKey ('b')) {
            b = map.get ('b');
        }
        if (map.containsKey ('a')) {
            a = map.get ('a');
        }
        if (map.containsKey ('l')) {
            l = map.get ('l') / 2;
        }
        if (map.containsKey ('o')) {
            o = map.get ('o') / 2;
        }
        if (map.containsKey ('n')) {
            n = map.get ('n');
        }

        return getMin (b, a, l, o, n);

    }

    private int getMin(int b, int a, int l, int o, int n) {
        int[] val = new int[]{b, a, l, o, n};
        Arrays.sort (val);
        return val[0];
    }
}

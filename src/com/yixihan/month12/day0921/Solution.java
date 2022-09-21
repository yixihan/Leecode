package com.yixihan.month12.day0921;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，
 * 则认为字符串 s1 和 s2 的 相似度为 k 。
 * <p>
 * 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
 * <p>
 * 输入：s1 = "ab", s2 = "ba"
 * 输出：1
 * <p>
 * 输入：s1 = "abc", s2 = "bca"
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-09-21-12:42
 */
public class Solution {

    int n;
    String t;

    public int kSimilarity(String s1, String s2) {
        if (s1.equals (s2)) {
            return 0;
        }
        t = s2;
        n = s1.length ();
        Map<String, Integer> map = new HashMap<> ();
        PriorityQueue<String> pq = new PriorityQueue<> ((a, b) -> {
            int v1 = f (a);
            int v2 = f (b);
            int d1 = map.get (a);
            int d2 = map.get (b);
            return (v1 + d1) - (v2 + d2);
        });
        map.put (s1, 0);
        pq.add (s1);
        while (!pq.isEmpty ()) {
            String poll = pq.poll ();
            int step = map.get (poll);
            char[] cs = poll.toCharArray ();
            int idx = 0;
            while (idx < n && cs[idx] == t.charAt (idx)) {
                idx++;
            }
            for (int i = idx + 1; i < n; i++) {
                if (cs[i] == t.charAt (idx) && cs[i] != t.charAt (i)) {
                    swap (cs, idx, i);
                    String nstr = String.valueOf (cs);
                    if (map.containsKey (nstr) && map.get (nstr) <= step + 1) {
                        continue;
                    }
                    if (nstr.equals (t)) {
                        return step + 1;
                    }
                    map.put (nstr, step + 1);
                    pq.add (nstr);
                    swap (cs, idx, i);
                }
            }
        }
        return -1; // never
    }

    private int f(String s) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += s.charAt (i) != t.charAt (i) ? 1 : 0;
        }
        return ans + 1 >> 1;
    }

    private void swap(char[] cs, int i, int j) {
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }
}

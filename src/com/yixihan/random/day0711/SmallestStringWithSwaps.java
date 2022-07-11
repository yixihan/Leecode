package com.yixihan.random.day0711;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * <p>
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *
 * @author : yixihan
 * @create : 2022-07-11-8:19
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length ();
        int[] p = new int[n];

        // 并查集数组初始化, 每个元素都是自己的父节点
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        // pairs 数组中合并, 看成一个集合
        for (List<Integer> pair : pairs) {
            union (pair.get (0), pair.get (1), p);
        }

        // 建立集合和优先队列对应哈希表
        Map<Integer, PriorityQueue<Character>> map = new HashMap<> ();

        // 对于各一个字符串下标 i, 首先找到它对应的集合 (父节点), 并且建立对应的优先队列, 并把 S[i]字符存储进优先队列
        for (int i = 0; i < n; i++) {
            int cur = find (i, p);
            if (!map.containsKey (cur)) {
                map.put (cur, new PriorityQueue<> ());
            }
            map.get (cur).offer (s.charAt (i));
        }

        // 建立字符串, 把对应下标所在集合对应的优先队列中 char 一个个加入字符串中
        StringBuilder sb = new StringBuilder ();
        for (int i = 0; i < n; i++) {
            sb.append (map.get (find (i, p)).poll ());
        }

        return sb.toString ();
    }

    private int find(int x, int[] p) {
        if (p[x] != x) {
            p[x] = find (p[x], p);
        }

        return p[x];
    }

    private void union(int x, int y, int[] p) {
        int px = find (x, p);
        int py = find (y, p);
        if (px != py) {
            p[px] = py;
        }
    }
}

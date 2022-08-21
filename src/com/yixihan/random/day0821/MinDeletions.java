package com.yixihan.random.day0821;

import java.util.PriorityQueue;

/**
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * <p>
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * <p>
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * <p>
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 * <p>
 * 输入：s = "aaabbbcc"
 * 输出：2
 * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
 * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
 * <p>
 * 输入：s = "ceabaacb"
 * 输出：2
 * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
 * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
 *
 * @author : yixihan
 * @create : 2022-08-21-9:08
 */
public class MinDeletions {

    public int minDeletions(String s) {
        int[] letters = new int[26];
        PriorityQueue<Integer> queue = new PriorityQueue<> ((o1, o2) -> o2 - o1);
        int ans = 0;

        for (char c : s.toCharArray ()) {
            letters[c - 'a']++;
        }

        for (int letter : letters) {
            if (letter != 0) {
                queue.add (letter);
            }
        }

        int max = queue.isEmpty () ? -1 : queue.poll ();
        while (!queue.isEmpty ()) {
            int val = queue.poll ();
            System.out.println ("max : " + max + ", val : " + val);
            if (val == max) {
                ans++;
                if (--val > 0) {
                    queue.add (val);
                }
            } else {
                max = val;
            }
        }

        return ans;
    }
}

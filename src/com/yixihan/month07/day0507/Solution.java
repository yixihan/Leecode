package com.yixihan.month07.day0507;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 * <p>
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。
 * 如果无法完成此基因变化，返回 -1 。
 * <p>
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * <p>
 * <p>
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * <p>
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * <p>
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : yixihan
 * @create : 2022-05-07-9:08
 */
public class Solution {
    private static final char[] CHARS = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (start.compareTo (end) == 0) {
            return 0;
        }
        Set<String> bankSet = Arrays.stream (bank).collect (Collectors.toSet ());
        Deque<String> queue = new ArrayDeque<> ();
        queue.addLast (start);
        int step = 0;
        while (!queue.isEmpty ()) {
            int len = queue.size ();
            for (int l = 0; l < len; l++) {
                String cur = queue.pollFirst ();
                for (int i = 0; i < cur.length (); i++) {
                    char c = cur.charAt (i);
                    for (char nxtChar : CHARS) {
                        if (nxtChar != c) {
                            String nxt = cur.substring (0, i) + nxtChar + cur.substring (i + 1);
                            if (bankSet.contains (nxt)) {
                                if (nxt.compareTo (end) == 0) {
                                    return step + 1;
                                }
                                bankSet.remove (nxt);
                                queue.addLast (nxt);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}

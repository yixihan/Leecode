package com.yixihan.month04.day0207;

import java.util.PriorityQueue;

/**
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 *
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 *
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *
 * @author : yixihan
 * @create : 2022-02-07-12:41
 */
public class Solution {

    public String longestDiverseString(int a, int b, int c) {

        StringBuilder sb = new StringBuilder(a + b + c);
        // 大顶堆，数量多的在最上面
        PriorityQueue<int[]> heap = new PriorityQueue<> ((x, y) -> y[1] - x[1]);

        // 初始化入堆
        if (a > 0) {
            heap.offer (new int[]{'a', a});
        }
        if (b > 0) {
            heap.offer (new int[]{'b', b});
        }
        if (c > 0) {
            heap.offer (new int[]{'c', c});
        }

        while (! heap.isEmpty ()) {
            int[] top = heap.poll ();
            int n = sb.length();

            // 如果字符串后两位等于数量最多的，那么数量最多的不能再加入字符串了
            if (n >= 2 && sb.charAt(n - 1) == top[0] && sb.charAt(n - 2) == top[0]) {
                if (! heap.isEmpty ()) {

                    // 我们就加入数量次多的
                    int[] mid = heap.poll ();
                    sb.append ((char) mid[0]);

                    // 数量次多的使用了一个之后还有剩余，重新入堆
                    if (--mid[1] > 0) {
                        heap.offer(mid);
                    }
                    heap.offer (top);
                }
            } else {

                // 不满足上面的条件，我们直接使用数量最多的
                sb.append ((char) top[0]);

                // 数量最多的使用了一个之后还有剩余，重新入堆
                if (-- top[1] > 0) {
                    heap.offer (top);
                }
            }
        }
        return sb.toString ();
    }
}

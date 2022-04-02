package com.yixihan.month02.day1215;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。
 * 为了方便起见，我们将编号为  x  的人简称为 "person  x  "。
 * <p>
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person  ai  比 person  bi  更有钱。
 * 另给你一个整数数组 quiet ，其中  quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰
 * （也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * <p>
 * 现在，返回一个整数数组 answer 作为答案，其中  answer[x] = y  的前提是，
 * 在所有拥有的钱肯定不少于  person  x  的人中，person  y  是最安静的人（也就是安静值  quiet[y]  最小的人）。
 * <p>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * 其他的答案也可以用类似的推理来解释。
 * <p>
 * 输入：richer = [], quiet = [0]
 * 输出：[0]
 *
 * @author : yixihan
 * @create : 2021-12-15-15:56
 */
public class LoudAndRich {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int length = quiet.length;
        int[][] w = new int[length][length];
        int[] in = new int[length];
        int[] result = new int[length];
        Deque<Integer> de = new ArrayDeque<> ();

        for (int[] value : richer) {
            int a = value[0];
            int b = value[1];

            w[a][b] = 1;
            in[b]++;
        }

        for (int i = 0; i < length; i++) {
            result[i] = i;
            if (in[i] == 0) {
                de.addLast (i);
            }
        }

        while (! de.isEmpty ()) {
            int temp = de.pollFirst ();

            for (int i = 0; i < length; i++) {
                if (w[temp][i] == 1) {
                    if (quiet[result[temp]] < quiet[result[i]]) {
                        result[i] = result[temp];
                    }
                    if (--in[i] == 0) {
                        de.addLast (i);
                    }
                }
            }
        }

        return result;
    }
}

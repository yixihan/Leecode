package com.yixihan.meituan.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 小美的一个兼职是美团的一名跑腿代购员，她有 n 个订单可以接，订单编号是 1~n ，
 * 但是因为订单的时效性，他只能选择其中 m 个订单接取，精明的小美当然希望自己总的获利是最大的，
 * 已知，一份订单会提供以下信息，跑腿价格 v ，商品重量 w kg，商品每重 1kg ，代购费用要加 2 元，
 * 而一份订单可以赚到的钱是跑腿价格和重量加价之和。小美可是开兰博基尼送货的人，所以自然不会在意自己会累这种事情。
 * 请问小美应该选择哪些订单，使得自己获得的钱最多。
 * 请你按照选择的订单编号的从小到大顺序，如果存在多种方案，输出订单编号字典序较小的方案。
 * <p>
 * 格式：
 * <p>
 * 输入：
 * - 输入第一行包含两个正整数 n，m，表示订单的数量和小美可以接的订单数量。
 * - 接下来有 n 行，第 i 行表示 i-1 号订单的信息。每行有两个正整数 v 和 w  ，表示一个订单的跑腿价格和商品重量。
 * 输出：
 * - 输出包含 m 个 1~n 之间的正整数，中间用空格隔开，表示选择的订单编号。
 * 示例：
 * <p>
 * 输入：
 * 5 2
 * 5 10
 * 8 9
 * 1 4
 * 7 9
 * 6 10
 * 输出：2 5
 *
 * @author : yixihan
 * @create : 2022-04-15-11:01
 */
public class Main003 {

    static int n;
    static int m;
    static int[][] orders;

    public static void main(String[] args) {
        InputReader in = new InputReader (System.in);
        n = in.nextInt ();
        m = in.nextInt ();
        orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            orders[i][0] = in.nextInt ();
            orders[i][1] = in.nextInt ();
        }

        List<Integer> ans = getAns ();
        for (int i = 0; i < ans.size (); i++) {
            if (i != ans.size () - 1) {
                System.out.print (ans.get (i) + " ");
            } else {
                System.out.println (ans.get (i));
            }
        }
    }

    public static List<Integer> getAns() {
        Queue<int[]> queue = new PriorityQueue<> (((o1, o2) -> {
            if (o2[0] + o2[1] * 2 == o1[0] + o1[1] * 2) {
                return o1[2] - o2[2];
            } else {
                return o2[0] + o2[1] * 2 - o1[0] - o1[1] * 2;
            }
        }));
        for (int i = 0; i < n; i++) {
            queue.add (new int[]{orders[i][0], orders[i][1], i + 1});
        }
        List<Integer> ans = new ArrayList<> ();
        while (ans.size () < m && !queue.isEmpty ()) {
            ans.add (queue.poll ()[2]);
        }

        ans.sort (Integer::compareTo);

        return ans;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader (new InputStreamReader (stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens ()) {
                try {
                    tokenizer = new StringTokenizer (reader.readLine ());
                } catch (IOException e) {
                    throw new RuntimeException (e);
                }
            }
            return tokenizer.nextToken ();
        }

        public int nextInt() {
            return Integer.parseInt (next ());
        }

    }
}

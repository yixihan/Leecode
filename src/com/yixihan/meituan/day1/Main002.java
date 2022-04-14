package com.yixihan.meituan.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，
 * 每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。已知货物入库的时候是按顺序堆放在一起的。
 * 如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以保证货物局部的顺序不变。
 * 已知货物最初是按 1~n 的顺序堆放的，每件货物的重量为 w[i] ,小美会根据单据依次不放回的取出货物。
 * 请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
 * <p>
 * 格式：
 * <p>
 * 输入：
 * - 输入第一行包含一个正整数 n ，表示货物的数量。
 * - 输入第二行包含 n 个正整数，表示 1~n 号货物的重量 w[i] 。
 * - 输入第三行有 n 个数，表示小美按顺序取出的货物的编号，也就是一个 1~n 的全排列。
 * 输出：
 * - 输出包含 n 行，每行一个整数，表示每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少。
 * <p>
 * 输入：
 * 5
 * 3 2 4 4 5
 * 4 3 5 2 1
 * 输出：
 * 9
 * 5
 * 5
 * 3
 * 0
 * 解释：
 * 原本的状态是 {{3,2,4,4,5}} ，取出 4 号货物后，得到 {{3,2,4},{5}} ，第一堆货物的和是 9 ，
 * 然后取出 3 号货物得到 {{3,2}{5}} ，此时第一堆和第二堆的和都是 5 ，以此类推。
 *
 * @author : yixihan
 * @create : 2022-04-14-16:07
 */
public class Main002 {

    static int n;
    static int[] w;
    static int[] preSum;
    static int[] out;
    static int[] ans;

    public static void main (String[] args) {
        InputStream inputStream = System.in;
        InputReader sc = new InputReader(inputStream);
        n = sc.nextInt ();
        w = new int[n];
        out = new int[n];
        ans = new int[n];
        preSum = new int[n + 1];
        preSum[0] = 0;

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt ();
        }

        for (int i = 0; i < n; i++) {
            out[i] = sc.nextInt ();
        }

        for (int i = 1; i <= n; i++) {
            preSum[i] = w[i - 1] + preSum[i - 1];
        }
        
        maxWeight ();
        show ();
    }

    public static void maxWeight () {

        TreeSet<Integer> boundSet = new TreeSet<>();
        boundSet.add(0);
        boundSet.add(n + 1);

        TreeMap<Integer, Integer> sumMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int pos = out[i];
            int left = boundSet.lower(pos);
            int right = boundSet.higher(pos);
            boundSet.add(pos);

            int segSum = preSum[right - 1] - preSum[left];
            Integer count = sumMap.get(segSum);
            if (count != null) {
                if (count == 1) {
                    sumMap.remove(segSum);
                } else {
                    sumMap.put(segSum, count - 1);
                }
            }

            int leftSum = preSum[pos - 1] - preSum[left];
            int rightSum = preSum[right - 1] - preSum[pos];
            sumMap.put(leftSum, sumMap.getOrDefault(leftSum, 0) + 1);
            sumMap.put(rightSum, sumMap.getOrDefault(rightSum, 0) + 1);
            ans[i] = sumMap.lastKey();

        }
        
    }

    private static void show () {
        for (int i = 0;i < n; i++) {
            System.out.println (ans[i]);
        }
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader (new InputStreamReader (stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer (reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

package com.yixihan.meituan.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 小团是一个莫得感情的 CtrlCV 大师，他有一个下标从 1 开始的序列 A 和一个初始全部为 -1 序列 B ，
 * 两个序列的长度都是 n 。他会进行若干次操作，每一次操作，他都会选择 A 序列中一段连续区间，
 * 将其粘贴到 B 序列中的某一个连续的位置，在这个过程中他也会查询 B 序列中某一个位置上的值。
 * 我们用如下的方式表示他的粘贴操作和查询操作：
 * 粘贴操作：1 k x y，表示把 A 序列中从下标 x 位置开始的连续 k 个元素粘贴到 B 序列中从下标 y 开始的连续 k 个位置上。
 * 原始序列中的元素被覆盖。（注意：输入数据可能会出现粘贴后 k 个元素超出 B 序列原有长度的情况，超出部分可忽略）
 * 查询操作：2 x，表示询问B序列下标 x 处的值是多少。
 * <p>
 * 格式：
 * <p>
 * 输入：
 * - 输入第一行包含一个正整数 n ，表示序列 A 和序列 B 的长度。
 * - 输入第二行包含 n 个正整数，表示序列 A 中的 n 个元素，
 * 第 i 个数字表示下标为 i 的位置上的元素，每一个元素保证在 10^9 以内。
 * - 输入第三行是一个操作数 m ，表示进行的操作数量。
 * - 接下来 m 行，每行第一个数字为 1 或 2 ，具体操作细节详见题面。
 * 输出：
 * - 对于每一个操作 2 输出一行，每行仅包含一个正整数，表示针对某一个询问的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 5
 * 1 2 3 4 5
 * 5
 * 2 1
 * 2 5
 * 1 2 3 4
 * 2 3
 * 2 5
 * 输出：
 * -1
 * -1
 * -1
 * 4
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * 5
 * 1 2 3 4 5
 * 9
 * 1 2 3 4
 * 2 3
 * 2 5
 * 1 2 2 3
 * 2 1
 * 2 2
 * 2 3
 * 2 4
 * 2 5
 * 输出：
 * -1
 * 4
 * -1
 * -1
 * 2
 * 3
 * 4
 *
 * @author : yixihan
 * @create : 2022-04-15-11:19
 */
public class Main004 {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader (new InputStreamReader (System.in));
        int n = Integer.parseInt (sc.readLine ());
        int[] a = new int[2 * n];
        int[] b = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            a[i] = -1;
            b[i] = -1;
        }

        String[] nums = sc.readLine ().split (" ");
        ;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt (nums[i]);
        }

        int m = Integer.parseInt (sc.readLine ());

        for (int i = 0; i < m; i++) {
            String[] ops = sc.readLine ().split (" ");

            if ("2".equals (ops[0])) {
                System.out.println (b[Integer.parseInt (ops[1]) - 1]);
            } else {
                System.arraycopy (a, Integer.parseInt (ops[2]) - 1, b, Integer.parseInt (ops[3]) - 1, Integer.parseInt (ops[1]));
            }
        }

    }
}

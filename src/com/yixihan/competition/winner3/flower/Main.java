package com.yixihan.competition.winner3.flower;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-03-27-11:31
 */
public class Main {
    private static int N = 1_00_005;
    private static int n;
    private static long ans = 0;
    private static long[] a = new long[N];
    private static long[] b = new long[N];//b[i]表示二进制下的第i位

    private static void update(long x) {
        for (int i = 60; i > 0; --i) {
            if (Long.toString (x, 2).length () > i) {//如果x在二进制表示下含有第i位
                if (b[i] != 0) {
                    x ^= b[i];
                } else {
                    b[i] = x;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner (System.in);
        n = scanner.nextInt ();
        //读入数据对于每一个数字都下放
        for (int i = 1; i <= n; ++i) {
            a[i] = scanner.nextLong ();
            update (a[i]);
        }
        //贪心的过程，ans看作一个二进制数，从高位开始，如果b[i]存在，
        //肯定优先跟b[i]异或，倒着让小值不会影响到大值

        for (int i = 60; i >= 0; --i) {
            if ((ans ^ (1l << i)) > ans) {
                ans ^= b[i];
            }

        }
        System.out.println (ans);
    }
}


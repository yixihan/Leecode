package com.yixihan.bishi.keda.q1;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-07-23-18:42
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final double PI = 3.1415927;
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            double hanWin = 0.5 * (1 - Math.cos (2 * PI * i / n));
            double num = x * hanWin;
            if (num == 0) {
                ans[i] = (long) num;
            } else {
                ans[i] = num > 0 ? (long) (num + 0.5) : (long) (num - 0.5);
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.println (ans[i]);
            } else {
                System.out.print (ans[i] + " ");
            }
        }


    }
}

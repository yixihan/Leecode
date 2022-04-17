package com.yixihan.competition.winner3.ctf;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-03-27-9:05
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long ans = getAns (n);

        System.out.println (ans);

        sc.close ();


    }

    private static long getAns(int n) {
        int x = 1;
        int count = 0;
        int size = 2;
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            if (++count > size) {
                size *= 2;
                x++;
                count = 1;
            }
            ans += x;
            System.out.println ("现在是第" + i + "天, 今天刷" + x + "道题");
        }

        return ans;
    }
}

package com.yixihan.bishi.meituan.q1;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-06-9:59
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt ();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println (getGiftNum (x, y));
        }
    }

    private static int getGiftNum (int x, int y) {
        int z = (x + y) / 3;

        return Math.min (z, Math.min (x, y));
    }
}

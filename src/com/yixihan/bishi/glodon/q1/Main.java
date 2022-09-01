package com.yixihan.bishi.glodon.q1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-31-20:03
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt ();
        }
        for (int i = 0; i < n; i++) {
            arr[i][1] = sc.nextInt ();
        }

        System.out.println (helper (arr, n));
    }

    private static int helper (int[][] arr, int n) {
        Arrays.sort (arr, Comparator.comparingInt (o -> o[0]));
        int cnt = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i][1] < arr[i - 1][1]) {
                cnt++;
            }
        }

        return cnt;
    }
}

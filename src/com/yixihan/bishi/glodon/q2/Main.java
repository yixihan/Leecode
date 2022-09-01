package com.yixihan.bishi.glodon.q2;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-31-20:13
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        boolean[] seat = new boolean[n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt ();
            int r = sc.nextInt ();
            int maxSeat = sc.nextInt ();
            int cnt = 0;
            for (int j = l - 1; j < r; j++) {
                if (seat[i] && cnt < maxSeat) {
                    cnt++;
                } else if (!seat[i] && cnt < maxSeat) {
                    seat[i] = true;
                    cnt++;
                } else if (cnt == maxSeat && seat[i]) {
                    seat[i] = false;
                }
            }
            count += r - l - cnt + 1;
        }
        System.out.println (n - count);
    }
}

/*
Scanner sc = new Scanner (System.in);
int n = sc.nextInt ();
int m = sc.nextInt ();
int[] seat = new int[n];
int count = 0;

for (int i = 0; i < m; i++) {
    int l = sc.nextInt ();
    int r = sc.nextInt ();
    int maxSeat = sc.nextInt ();
    int cnt = 0;
    for (int j = l - 1; j < r; j++) {
        if (seat[i] == 1 && cnt < maxSeat) {
            cnt++;
        } else if (seat[i] == 0 && cnt < maxSeat) {
            seat[i] = 1;
            cnt++;
        } else if (cnt == maxSeat && seat[i] == 1) {
            seat[i] = 0;
        }
    }
    count += r - l - cnt + 1;
}
System.out.println (n - count);
 */
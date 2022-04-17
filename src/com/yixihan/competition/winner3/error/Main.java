package com.yixihan.competition.winner3.error;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-03-27-12:04
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt ();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int ans = getAns (n, nums);
        System.out.println (ans);
    }

    private static int getAns(int n, int[] nums) {

        return 0;
    }
}

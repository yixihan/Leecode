package com.yixihan.bishi.xhs.q2;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-28-15:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        long k = sc.nextLong ();
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong ();
        }
        sc.close ();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i] * nums[j] >= k) {
                    ans++;
                }
            }
        }

        System.out.println (ans);
    }
}

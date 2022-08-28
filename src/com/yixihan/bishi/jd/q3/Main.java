package com.yixihan.bishi.jd.q3;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-27-19:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();

        System.out.println (helper (n));
    }

    private static int helper (int n) {
        if (n < 6) {
            return 0;
        }
        int ans = 1;
        int cnt = 2;

        while (n > cnt * 3) {
            int tmp = n - cnt * 3;
            ans += (3 * tmp) % 1000000007;
            cnt++;
        }

        return ans ;
    }
}

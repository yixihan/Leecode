package com.yixihan.bishi.jd.q1;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-27-19:11
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int k = sc.nextInt ();
        String str = sc.next ();

        System.out.println (helper (str, k));
    }

    private static String helper (String str, int k) {
        return str.substring (0, k).toUpperCase () + str.substring (k).toLowerCase ();
    }
}

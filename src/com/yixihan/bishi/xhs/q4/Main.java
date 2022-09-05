package com.yixihan.bishi.xhs.q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-09-04-15:15
 */
public class Main {

    static int n;
    static int m;
    static int k;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        m = sc.nextInt ();
        k = sc.nextInt ();
        nums = new int[2 * n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt ();
        }

        System.out.println (helper ());

    }

    private static int helper() {
        for (int i = n - 1, j = n; i >= 0; i--, j++) {
            nums[j] = nums[i];
        }
        System.out.println (Arrays.toString (nums));

        return nums[((k + 2 * n) % (2 * n)) - 1];
    }
}
/*
1 2 3
1 2 3 3 2 1
1 2 3 3 2 1  1 2 3 3 2 1
1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1
1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1  1 2 3 3 2 1
 */
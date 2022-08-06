package com.yixihan.bishi.meituan.q2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-06-9:59
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[][] tmp = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] == 0) {
                tmp[i + 1][0] = tmp[i][0];
                tmp[i + 1][1] = tmp[i][1];
                tmp[i + 1][2] = tmp[i][2] + 1;
            } else if (nums[i] > 0) {
                tmp[i + 1][0] = tmp[i][0] + 1;
                tmp[i + 1][1] = tmp[i][1];
                tmp[i + 1][2] = tmp[i][2];
            } else {
                tmp[i + 1][0] = tmp[i][0];
                tmp[i + 1][1] = tmp[i][1] + 1;
                tmp[i + 1][2] = tmp[i][2];
            }
        }

        for (int[] val : tmp) {
            System.out.println (Arrays.toString (val));
        }

        int min = n;
        int[] last = tmp[n];
        for (int i = 0; i <= n; i++) {
            int sum = (last[1] - tmp[i][1]) + last[2] + tmp[i][0];
            min = Math.min (min, sum);
        }

        System.out.println (min);
    }
}

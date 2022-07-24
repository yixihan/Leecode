package com.yixihan.bishi.keda.q2;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-07-23-19:12
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[][] points = new int[n][2];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt ();
            points[i][1] = sc.nextInt ();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    double disA = Math.pow (points[i][0] - points[j][0], 2) + Math.pow (points[i][1] - points[j][1], 2);
                    double disB = Math.pow (points[j][0] - points[k][0], 2) + Math.pow (points[j][1] - points[k][1], 2);
                    double disC = Math.pow (points[k][0] - points[i][0], 2) + Math.pow (points[k][1] - points[i][1], 2);

                    if (disA + disB == disC || disA + disC == disB || disC + disB == disA) {
                        ans++;
                    }
                }
            }
        }

        System.out.println (ans);
    }

}

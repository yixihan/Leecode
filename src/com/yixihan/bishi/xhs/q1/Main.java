package com.yixihan.bishi.xhs.q1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-28-15:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int id = sc.nextInt ();

        PriorityQueue<int[]> queue = new PriorityQueue<> ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += sc.nextInt ();
            }
            queue.add (new int[]{sum, i + 1});
        }

        while (!queue.isEmpty ()) {
            int[] tmp = queue.poll ();
            if (tmp[1] == id) {
                break;
            }
            ans++;
        }

        System.out.println (ans);
    }
}

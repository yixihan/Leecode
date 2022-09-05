package com.yixihan.bishi.xhs.q6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-09-04-15:58
 */
public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] graph;


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        m = sc.nextInt ();
        k = sc.nextInt ();
        int[][] tmp = new int[m][2];
        int[] tolls = new int[m];

        for (int i = 0; i < m; i++) {
            tmp[i][0] = sc.nextInt ();
        }
        for (int i = 0; i < m; i++) {
            tmp[i][1] = sc.nextInt ();
        }
        for (int i = 0; i < m; i++) {
            tolls[i] = sc.nextInt ();
        }

        initGraph (tmp, tolls);
        System.out.println (helper ());
    }

    private static void initGraph(int[][] tmp, int[] tolls) {
        graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            graph[tmp[i][0] - 1][tmp[i][1] - 1] = tolls[i];
            graph[tmp[i][1] - 1][tmp[i][0] - 1] = tolls[i];
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println (Arrays.toString (graph[i]));
//        }
    }

    private static int helper() {
        int minCost = Integer.MAX_VALUE;
        int now = 0;


        for (int i = now; i < n; i++) {
            if (graph[now][i] != 0) {
//                System.out.println ("now : " + (now + 1) + ", next : " + (i + 1) + ", cost : " + graph[now][i]);
                minCost = Math.min (minCost, dfs (i, graph[now][i], 1));
            }
        }

        return minCost;
    }

    private static int dfs(int now, int cost, int dis) {

        if (now == n - 1) {
            return cost;
        }
        if (dis > k) {
            return Integer.MAX_VALUE;
        }

        for (int i = now; i < n; i++) {
            if (graph[now][i] != 0) {
//                System.out.println ("now : " + (now + 1) + ", next : " + (i + 1) + ", cost : " + Math.max (cost, graph[now][i]));
                dfs (i, Math.max (cost, graph[now][i]), dis + 1);
            }
        }

        return cost;
    }
}

package com.yixihan.offer.day09;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 *
 * 输入: 
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * @author : yixihan
 * @create : 2022-03-01-12:35
 */
public class MaxValue {
    public int maxValue(int[][] grid) {

        // 方法一 : 动态规划, 自己写的版本
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int maxVal = 0;
//                if (i - 1 >= 0) {
//                    maxVal = Math.max (maxVal, dp[i - 1][j]);
//                }
//                if (j - 1 >= 0) {
//                    maxVal = Math.max (maxVal, dp[i][j - 1]);
//                }
//
//                dp[i][j] = grid[i][j] + maxVal;
//            }
//        }
//
//
//        return dp[m - 1][n - 1];

        // 方法二 : 动态规划, 滚动数组
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[n];
    }
}

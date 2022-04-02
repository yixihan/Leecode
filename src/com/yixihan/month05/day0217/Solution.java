package com.yixihan.month05.day0217;

import java.awt.*;

/**
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。
 * 行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 *
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 *
 * @author : yixihan
 * @create : 2022-02-17-6:45
 */
public class Solution {

    final int [][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};


    public double knightProbability(int n, int k, int row, int column) {

        Double [][][] dp = new Double[k + 1][n][n];
        return dfs(n, k, row, column, dp) / Math.pow(8, k);
    }

    private double dfs(int n, int k, int row, int column, Double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[k][row][column] != null) {
            return dp[k][row][column];
        }
        double live = 0;
        for (int[] dir : dirs) {
            live += dfs(n, k - 1, row + dir[0], column + dir[1], dp);
        }
        dp[k][row][column] = live;
        return live;
        
    }


}

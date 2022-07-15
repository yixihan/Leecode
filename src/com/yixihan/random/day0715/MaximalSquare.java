package com.yixihan.random.day0715;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 *
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-07-15-9:21
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min (dp[i - 1][j - 1], Math.min (dp[i - 1][j], dp[i][j - 1])) + 1;
                    ans = Math.max (dp[i][j], ans);
                }
            }
        }

        return ans * ans;
    }
}

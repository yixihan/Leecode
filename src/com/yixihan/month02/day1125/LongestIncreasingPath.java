package com.yixihan.month02.day1125;

/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * <p>
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是  [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 输入：matrix = [[1]]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2021-11-25-13:44
 */
public class LongestIncreasingPath {

    private int m, n;
    private final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)

                res = Math.max(res, dfs(matrix, i, j, dp));
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = 1;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];

            if (row >= 0 && row < m && col >= 0 && col < n && matrix[i][j] < matrix[row][col]) {
                dp[i][j] = Math.max(dp[i][j], dfs(matrix, row, col, dp) + 1);
            }
        }

        return dp[i][j];
    }
}

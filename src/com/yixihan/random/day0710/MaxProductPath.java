package com.yixihan.random.day0710;

/**
 * 给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 * <p>
 * 在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 * <p>
 * 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
 * <p>
 * 注意，取余是在得到最大积之后执行的。
 * <p>
 * 输入：grid = [[-1,-2,-3],
 * [-2,-3,-3],
 * [-3,-3,-2]]
 * 输出：-1
 * 解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1
 * <p>
 * 输入：grid = [[1,-2,1],
 * [1,-2,1],
 * [3,-4,1]]
 * 输出：8
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)
 * <p>
 * 输入：grid = [[1, 3],
 * [0,-4]]
 * 输出：0
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)
 * <p>
 * 输入：grid = [[ 1, 4,4,0],
 * [-2, 0,0,1],
 * [ 1,-1,1,1]]
 * 输出：2
 * 解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)
 *
 * @author : yixihan
 * @create : 2022-07-10-9:26
 */
public class MaxProductPath {

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] minDp = new long[m][n];
        long[][] maxDp = new long[m][n];
        maxDp[0][0] = minDp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            maxDp[i][0] = minDp[i][0] = maxDp[i - 1][0] * grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            maxDp[0][j] = minDp[0][j] = maxDp[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxDp[i][j] = Math.max (maxDp[i][j - 1], maxDp[i - 1][j]) * grid[i][j];
                    minDp[i][j] = Math.min (minDp[i][j - 1], minDp[i - 1][j]) * grid[i][j];
                } else {
                    maxDp[i][j] = Math.min (minDp[i][j - 1], minDp[i - 1][j]) * grid[i][j];
                    minDp[i][j] = Math.max (maxDp[i][j - 1], maxDp[i - 1][j]) * grid[i][j];
                }
            }
        }

        return maxDp[m - 1][n - 1] < 0 ? -1 : (int) (maxDp[m - 1][n - 1] % (1000000007));
    }

}

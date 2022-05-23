package com.yixihan.binary_2.day15;

/**
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 * <p>
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * <p>
 * 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * 输出：2
 * 解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
 * <p>
 * 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-05-23-13:18
 */
public class MaxSideLength {

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        int[][] preSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = mat[i - 1][j - 1] + preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i && k <= j; k++) {
                    int tmp = preSum[i][j] - preSum[i - k][j] - preSum[i][j - k] + preSum[i - k][j - k];

                    if (tmp > threshold) {
                        break;
                    }

                    ans = Math.max (ans, k);
                }
            }
        }

        return ans;

    }
}

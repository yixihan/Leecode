package com.yixihan.programming_ability_1.day7;

/**
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 *
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 *
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 *
 * 输入：mat = [[1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1]]
 * 输出：8
 *
 * 输入：mat = [[5]]
 * 输出：5
 *
 * @author : yixihan
 * @create : 2022-03-17-13:36
 */
public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            ans += mat[i][i];
            if (i != n - 1 - i) {
                ans += mat[i][n - 1 - i];
            }
        }

        return ans;

    }
}

package com.yixihan.data_structure_2.day3;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @author : yixihan
 * @create : 2022-03-26-8:10
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int index = 1;

        while (index <= n * n) {

            for (int i = left; i <= right; i++) {
                matrix[top][i] = index++;
            }

            if (++top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = index++;
            }

            if (--right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = index++;
            }

            if (--bottom < top) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = index++;
            }

            if (++left > right) {
                break;
            }
        }

        return matrix;
    }
}

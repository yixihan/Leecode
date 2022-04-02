package com.yixihan.programming_ability_2.day7;

import java.util.Arrays;

/**
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。
 * 现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 *
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 *
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 *
 * @author : yixihan
 * @create : 2022-03-29-9:09
 */
public class FindRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (equals (mat, target)) {
                return true;
            } else {
                rotate (mat);
            }
        }

        return false;
    }

    private void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    private boolean equals (int[][] mat, int[][] target) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            if (! Arrays.equals (mat[i], target[i])) {
                return false;
            }
        }

        return true;
    }
}

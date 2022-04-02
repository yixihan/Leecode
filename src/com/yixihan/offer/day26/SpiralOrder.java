package com.yixihan.offer.day26;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author : yixihan
 * @create : 2022-03-17-13:09
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;

        while (index < m * n) {
            // 从左往右走
            for (int i = l; i <= r; i++) {
                ans[index++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }

            // 从上往下走
            for (int i = t; i <= b; i++) {
                ans[index++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }

            // 从右往左走
            for (int i = r; i >= l; i--) {
                ans[index++] = matrix[b][i];
            }
            if (--b < t) {
                break;
            }

            // 从下往上走
            for (int i = b; i >= t; i--) {
                ans[index++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }

        return ans;
    }
}

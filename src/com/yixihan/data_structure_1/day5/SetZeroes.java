package com.yixihan.data_structure_1.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * @author : yixihan
 * @create : 2022-03-14-12:00
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<> ();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add (new int[]{i, j});
                }
            }
        }

        while (! list.isEmpty ()) {
            int[] tmp = list.remove (0);

            for (int i = 0; i < m; i++) {
                matrix[i][tmp[1]] = 0;
            }
            for (int j = 0; j < n; j++) {
                matrix[tmp[0]][j] = 0;
            }
        }

    }
}

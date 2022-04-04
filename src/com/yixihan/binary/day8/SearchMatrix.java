package com.yixihan.binary.day8;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-04-04-14:27
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = m - 1, j = 0; i >= 0 && j < n; ) {
            // System.out.println (i + ", " + j);
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }

        return false;
    }
}

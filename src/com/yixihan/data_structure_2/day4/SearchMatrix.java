package com.yixihan.data_structure_2.day4;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-03-27-7:50
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int indexI = m - 1, indexJ = 0; indexI >= 0 && indexI < m && indexJ >= 0 && indexJ < n; ) {
            if (matrix[indexI][indexJ] < target) {
                indexJ++;
            } else if (matrix[indexI][indexJ] > target) {
                indexI--;
            } else {
                return true;
            }
        }

        return false;
    }
}

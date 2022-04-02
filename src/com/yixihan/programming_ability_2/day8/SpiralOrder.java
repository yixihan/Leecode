package com.yixihan.programming_ability_2.day8;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author : yixihan
 * @create : 2022-03-30-11:46
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<> ();

        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;

        while (true) {

            for (int i = l; i <= r; i++) {
                ans.add (matrix[t][i]);
            }
            if (t++ >= b) {
                break;
            }

            for (int i = t; i <= b; i++) {
                ans.add (matrix[i][r]);
            }
            if (r-- <= l) {
                break;
            }

            for (int i = r; i >= l; i--) {
                ans.add (matrix[b][i]);
            }
            if (b-- <= t) {
                break;
            }

            for (int i = b; i >= t; i--) {
                ans.add (matrix[i][l]);
            }
            if (l++ >= r) {
                break;
            }
        }

        return ans;
    }
}

package com.yixihan.month04.day0215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *
 * @author : yixihan
 * @create : 2022-02-15-6:53
 */
public class LuckyNumbers {

    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndexJ = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (minValue > matrix[i][j]) {
                    minValue = matrix[i][j];
                    minIndexJ = j;
                }
            }
            int k;
            for (k = 0; k < matrix.length; k++) {
                if (minValue < matrix[k][minIndexJ]) {
                    break;
                }
            }
            if (k >= matrix.length) {
                list.add (minValue);
            }
        }

        return list;
    }

}

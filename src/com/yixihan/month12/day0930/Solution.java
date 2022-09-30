package com.yixihan.month12.day0930;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 *
 * @author yixihan
 * @date 2022-09-30-9:07
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        Set<Integer> set1 = new HashSet<> ();
        Set<Integer> set2 = new HashSet<> ();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    set1.add (i);
                    set2.add (j);
                }
            }
        }

        setXZeroe (matrix, set1);
        setYZeroe (matrix, set2);
    }

    private void setXZeroe(int[][] matrix, Set<Integer> set) {
        for (int idx : set) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[idx][j] = 0;
            }
        }
    }

    private void setYZeroe(int[][] matrix, Set<Integer> set) {
        for (int idx : set) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][idx] = 0;
            }
        }
    }
}

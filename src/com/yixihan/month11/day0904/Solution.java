package com.yixihan.month11.day0904;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * <p>
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,0,1],
 * [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * <p>
 * 输入：mat = [[0,0,0,1],
 * [1,0,0,0],
 * [0,1,1,0],
 * [0,0,0,0]]
 * 输出：2
 * <p>
 * 输入：mat = [[0,0,0,0,0],
 * [1,0,0,0,0],
 * [0,1,0,0,0],
 * [0,0,1,0,0],
 * [0,0,0,1,1]]
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-09-04-9:39
 */
public class Solution {

    public int numSpecial(int[][] mat) {
        int ans = 0;
        List<int[]> list = new ArrayList<> ();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    list.add (new int[]{i, j});
                }
            }
        }

        for (int[] point : list) {
            boolean flag = true;
            for (int i = 0; i < mat.length; i++) {
                if (i != point[0] && mat[i][point[1]] == 1) {
                    flag = false;
                    break;
                }
            }
            for (int j = 0; j < mat[0].length; j++) {
                if (j != point[1] && mat[point[0]][j] == 1) {
                    flag = false;
                    break;
                }
            }
            ans += flag ? 1 : 0;
        }

        return ans;
    }
}

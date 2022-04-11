package com.yixihan.binary_1.day8;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-04-04-14:12
 */
public class CountNegatives {
    public int countNegatives(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = m - 1; i >= 0 && grid[i][n - 1] < 0; i--) {
            for (int j = n - 1; j >= 0 && grid[i][j] < 0; j--) {
                ans++;
            }
        }

        return ans;
    }
}

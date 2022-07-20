package com.yixihan.month10.day0720;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * <p>
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *
 * @author : yixihan
 * @create : 2022-07-20-9:42
 */
public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] tmp = new int[m * n];
        int index = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                tmp[index++] = ints[j];
            }
        }
        List<List<Integer>> ans = new ArrayList<> ();
        for (int i = 0; i < m; i++) {
            ans.add (new ArrayList<> (n));
        }

        int cnt = 0;
        index = 0;
        for (int i = m * n - (k % m * n); i < m * n; i++) {
            ans.get (index).add (tmp[i]);
            if (++cnt >= n) {
                cnt = 0;
                index++;
            }
        }
        for (int i = 0; i < m * n - k; i++) {
            ans.get (index).add (tmp[i]);
            if (++cnt >= n) {
                cnt = 0;
                index++;
            }
        }

        return ans;
    }
}

package com.yixihan.month07.day0427;

import java.util.ArrayList;
import java.util.List;

/**
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。
 * “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * <p>
 * 这个岛被分割成一个由若干方形单元格组成的网格。
 * 给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * <p>
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，
 * 雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * <p>
 * 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋 。
 * <p>
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * <p>
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 *
 * @author : yixihan
 * @create : 2022-04-27-9:14
 */
public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ret = new ArrayList<> ();
        int m = heights.length;
        if (m < 1) return ret;
        int n = heights[0].length;
        boolean[][] Pacific = new boolean[m][n];
        boolean[][] Atlantic = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            dfs (heights, i, 0, Pacific, heights[i][0]);
            dfs (heights, i, n - 1, Atlantic, heights[i][n - 1]);
        }
        for (int i = 0; i < n; ++i) {
            dfs (heights, 0, i, Pacific, heights[0][i]);
            dfs (heights, m - 1, i, Atlantic, heights[m - 1][i]);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                if (Pacific[i][j] && Atlantic[i][j]) {
                    ArrayList<Integer> list = new ArrayList<> ();
                    list.add (i);
                    list.add (j);
                    ret.add (new ArrayList<> (list));
                }

        }
        return ret;
    }

    private void dfs(int[][] m, int x, int y, boolean[][] visited, int pre) {
        if (x < 0 || y < 0 || x >= m.length || y >= m[0].length || visited[x][y] || m[x][y] < pre) return;
        visited[x][y] = true;
        dfs (m, x + 1, y, visited, m[x][y]);
        dfs (m, x - 1, y, visited, m[x][y]);
        dfs (m, x, y + 1, visited, m[x][y]);
        dfs (m, x, y - 1, visited, m[x][y]);
    }
}

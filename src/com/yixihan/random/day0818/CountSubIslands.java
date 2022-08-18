package com.yixihan.random.day0818;

/**
 * 给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。
 * 一个 岛屿 是由 四个方向 （水平或者竖直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。
 * <p>
 * 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，
 * 那么我们称 grid2 中的这个岛屿为 子岛屿 。
 * <p>
 * 请你返回 grid2 中 子岛屿 的 数目 。
 * <p>
 * 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * 输出：3
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
 * <p>
 * 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * 输出：2
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
 *
 * @author : yixihan
 * @create : 2022-08-18-13:20
 */
public class CountSubIslands {

    int m;
    int n;
    int[][] grid1;
    int[][] grid2;
    int ans = 0;
    boolean flag = false;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        m = grid1.length;
        n = grid1[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] != 0) {
                    flag = false;
                    dfs (i, j);
                    ans += flag ? 0 : 1;
                }
            }
        }

        return ans;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid2[x][y] == 0) {
            return;
        }
        if (grid1[x][y] != 1) {
            flag = true;
        }
        grid2[x][y] = 0;

        dfs (x + 1, y);
        dfs (x - 1, y);
        dfs (x, y + 1);
        dfs (x, y - 1);
    }
}

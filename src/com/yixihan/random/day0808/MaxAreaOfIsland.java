package com.yixihan.random.day0808;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * <p>
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-08-08-8:40
 */
public class MaxAreaOfIsland {

    int m;
    int n;
    boolean[][] visited;
    int[][] grid;
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs (i, j, 0);
                    maxArea = Math.max (area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int x, int y, int area) {
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
            area++;
            visited[x][y] = true;
            area += dfs (x + 1, y, 0);
            area += dfs (x - 1, y, 0);
            area += dfs (x, y + 1, 0);
            area += dfs (x, y - 1, 0);

        }
        return area;
    }
}

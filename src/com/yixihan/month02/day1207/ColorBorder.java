package com.yixihan.month02.day1207;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 *
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 *
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 *
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 *
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *
 *
 * 从题目给定的 (row, col)(row,col) 进行出发，如果遍历到「连通分量的边界」格子，则使用 colorcolor 进行上色。
 *
 * 同一「连通分量」的「非边界」格子满足：当前格子的四联通方向均存在相邻格子，且当前格子与四联通相邻格子颜色一致。
 *
 * 也就是说，我们从 (row, col)(row,col) 进行出发，遍历 (row, col)(row,col) 所在的「连通分量」，
 * 如果遍历到的「连通分量」格子不满足上述条件（边界格子），则进行上色。
 *
 * @author : yixihan
 * @create : 2021-12-07-12:17
 */
public class ColorBorder {

    /**
     * 解题思路 :
     * 构造 ansans 矩阵作为答案，同时 ansans 也作为判重数组使用（通过判断 ans[i][j]ans[i][j] 是否为 00 来得知是否被处理）；
     *
     * 起始时，将 (row, col)(row,col) 位置进行入队，每次从队列中取出元素进行「四联通拓展」：
     *
     * 拓展格子必须与起点格子处于同一「连通分量」，即满足两者起始颜色相同；
     *
     * 进行「四联通拓展」的同时，记录当前出队是否为边界格子。若为边界格子，则使用 colorcolor 进行上色；
     *
     * 跑完 BFS 后，对 ansans 进行遍历，将未上色（ans[i][j] = 0ans[i][j]=0）的位置使用原始色（grid[i][j]grid[i][j]）进行上色。
     */
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> d = new ArrayDeque<> ();

        d.addLast (new int[]{row, col});

        while (!d.isEmpty ()) {
            int[] poll = d.pollFirst ();
            int x = poll[0];
            int y = poll[1];
            int cnt = 0;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                if (grid[x][y] != grid[nx][ny]) {
                    continue;
                } else {
                    cnt++;
                }

                if (result[nx][ny] != 0) {
                    continue;
                }

                d.addLast (new int[]{nx, ny});
            }

            result[x][y] = cnt == 4 ? grid[x][y] : color;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = grid[i][j];
                }
            }
        }

        return result;
    }
}

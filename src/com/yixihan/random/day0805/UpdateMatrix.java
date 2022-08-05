package com.yixihan.random.day0805;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 *
 * @author : yixihan
 * @create : 2022-08-05-8:47
 */
public class UpdateMatrix {

    int m;
    int n;
    boolean[][] visited;
    Queue<Integer[]> queue;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        visited = new boolean[m][n];
        queue = new ArrayDeque<> ();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer (new Integer[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dis = 0;
        while (!queue.isEmpty ()) {
            int size = queue.size ();
            for (int i = 0; i < size; i++) {
                Integer[] node = queue.poll ();
                mat[node[0]][node[1]] = dis;
                bfs (node[0] + 1, node[1]);
                bfs (node[0] - 1, node[1]);
                bfs (node[0], node[1] + 1);
                bfs (node[0], node[1] - 1);
            }
            dis++;
        }

        return mat;
    }

    private void bfs(int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
            queue.offer (new Integer[]{i, j});
            visited[i][j] = true;
        }
    }
}

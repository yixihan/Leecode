package com.yixihan.month01.day1103;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 *
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 *
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 *
 *
 * @author : yixihan
 * @create : 2021-11-03-18:47
 */
public class TrapRainWater {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 使用堆解决
     */
    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        
        // 将边界加入堆
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    heap.offer(new int[]{i, j, heightMap[i][j]});
                }
            }
        }

        int res = 0;

        // 每次从堆中弹出最小的元素，并检查它上下左右的位置是否可以注水
        while (! heap.isEmpty()) {
            int[] element = heap.poll();
            int x = element[0];
            int y = element[1];
            int h = element[2];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if (heightMap[nx][ny] < h) {
                        res += h - heightMap[nx][ny];
                    }
                    visited[nx][ny] = true;
                    heap.offer(new int[] {nx, ny, Math.max(h, heightMap[nx][ny])});
                }
            }
        }

        return  res;
    }

    @Test
    public void test () {
        int[][] heightMap = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};

        System.out.println(trapRainWater(heightMap));
    }
}



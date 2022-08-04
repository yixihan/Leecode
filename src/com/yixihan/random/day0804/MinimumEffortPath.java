package com.yixihan.random.day0804;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
 * 一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
 * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 *
 * @author : yixihan
 * @create : 2022-08-04-9:36
 */
public class MinimumEffortPath {


    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> queue = new PriorityQueue<> (Comparator.comparingInt (o -> o[2]));
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] map = new boolean[rows][columns];
        int[][] steps = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        queue.add (new int[]{0, 0, 0});
        while (!queue.isEmpty ()) {
            int[] first = queue.poll ();
            if (map[first[0]][first[1]]) {
                continue;
            }
            map[first[0]][first[1]] = true;

            if (first[0] == rows - 1 && first[1] == columns - 1) {
                return first[2];
            }

            for (int[] step : steps) {
                int i = first[0] + step[0];
                int j = first[1] + step[1];

                if (i >= 0 && i < rows && j >= 0 && j < columns && !map[i][j]) {
                    int cnt = Math.max (first[2], Math.abs (heights[i][j] - heights[first[0]][first[1]]));
                    queue.add (new int[]{i, j, cnt});
                }
            }
        }

        return 0;
    }


}

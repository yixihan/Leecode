package com.yixihan.month07.day0426;

/**
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * <p>
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 * <p>
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * <p>
 * 返回 所有三个投影的总面积 。
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * <p>
 * 输入：grid = [[2]]
 * 输出：5
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：8
 *
 * @author : yixihan
 * @create : 2022-04-26-9:54
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        /*
        正视图：每一行最大值之和；
        侧视图：每一列最大值之和；
        俯视图：柱子个数；
        */

        int area1 = 0;
        int area2 = 0;
        int area3 = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            int max = grid[i][0];
            for (int j = 0; j < n; j++) {
                max = Math.max (max, grid[i][j]);
                area1++;
            }
            area2 += max;
        }

        for (int j = 0; j < n; j++) {
            int max = grid[0][j];
            for (int i = 0; i < n; i++) {
                max = Math.max (max, grid[i][j]);
            }
            area3 += max;
        }
        System.out.println (area1);
        System.out.println (area2);
        System.out.println (area3);

        return area1 + area2 + area3;
    }
}

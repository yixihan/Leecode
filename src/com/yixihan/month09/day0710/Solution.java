package com.yixihan.month09.day0710;

/**
 * 一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
 * <p>
 * 0 表示这个格子是空的，所以你可以穿过它。
 * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 * -1 表示这个格子里有荆棘，挡着你的路。
 * 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
 * <p>
 * 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 * 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 * 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
 * <p>
 * 输入: grid =
 * [[0, 1, -1],
 * [1, 0, -1],
 * [1, 1,  1]]
 * 输出: 5
 * 解释：
 * 玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
 * 在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
 * 接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
 * 在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
 *
 * @author : yixihan
 * @create : 2022-07-10-8:25
 */
public class Solution {
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        dp = new int[row][col][row];
        for (int x1 = 0; x1 < row; x1++) {
            for (int y1 = 0; y1 < col; y1++) {
                for (int x2 = x1; x2 <= Math.min (x1 + y1, row - 1); x2++) {
                    dp[x1][y1][x2] = calc (grid, x1, y1, x2, x1 + y1 - x2);
                    dp[x2][x1 + y1 - x2][x1] = dp[x1][y1][x2];
                }
            }
        }
        return Math.max (0, dp[row - 1][col - 1][row - 1]);
    }

    private int calc(int[][] grid, int x1, int y1, int x2, int y2) {
        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (x1 + y1 == 0) {
            return grid[0][0];
        }

        int result = Integer.MIN_VALUE;
        if (x1 > 0 && x2 > 0) {
            result = Math.max (dp[x1 - 1][y1][x2 - 1], result);
        }
        if (x1 > 0 && y2 > 0) {
            result = Math.max (dp[x1 - 1][y1][x2], result);
        }
        if (y1 > 0 && x2 > 0) {
            result = Math.max (dp[x1][y1 - 1][x2 - 1], result);
        }
        if (y1 > 0 && y2 > 0) {
            result = Math.max (dp[x1][y1 - 1][x2], result);
        }
        result += grid[x1][y1] + (x1 == x2 ? 0 : grid[x2][y2]);
        return result;
    }

}

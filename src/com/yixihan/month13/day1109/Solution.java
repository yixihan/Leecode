package com.yixihan.month13.day1109;

import java.util.Arrays;

/**
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * <p>
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * <p>
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。
 * 注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * <p>
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * <p>
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 *
 * @author yixihan
 * @date 2022/11/9 8:58
 */
public class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int[] e : dp) {
            Arrays.fill (e, n);
        }
        for (int[] e : mines) {
            dp[e[0]][e[1]] = 0;
        }
        for (int i = 0; i < n; ++i) {
            int left = 0, right = 0, up = 0, down = 0;
            for (int j = 0, k = n - 1; j < n; ++j, --k) {
                left = dp[i][j] > 0 ? left + 1 : 0;
                right = dp[i][k] > 0 ? right + 1 : 0;
                up = dp[j][i] > 0 ? up + 1 : 0;
                down = dp[k][i] > 0 ? down + 1 : 0;
                dp[i][j] = Math.min (dp[i][j], left);
                dp[i][k] = Math.min (dp[i][k], right);
                dp[j][i] = Math.min (dp[j][i], up);
                dp[k][i] = Math.min (dp[k][i], down);
            }
        }
        int ans = 0;
        for (int[] e : dp) {
            ans = Math.max (ans, Arrays.stream (e).max ().getAsInt ());
        }
        return ans;
    }
}

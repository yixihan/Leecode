package com.yixihan.month10.day0718;

/**
 * 病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
 * <p>
 * 假设世界由 m x n 的二维矩阵 isInfected 组成，
 * isInfected[i][j] == 0 表示该区域未感染病毒，
 * isInfected[i][j] == 1 表示该区域已感染病毒。
 * 可以在任意 2 个相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
 * <p>
 * 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。
 * 现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），
 * 且该感染区域对未感染区域的威胁最大且 保证唯一 。
 * <p>
 * 你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
 * <p>
 * 输入: isInfected = [[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]
 * 输出: 10
 * 解释:一共有两块被病毒感染的区域。
 * 在第一天，添加 5 墙隔离病毒区域的左侧。病毒传播后的状态是:
 * 第二天，在右侧添加 5 个墙来隔离病毒区域。此时病毒已经被完全控制住了。
 * <p>
 * 输入: isInfected = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出: 4
 * 解释: 虽然只保存了一个小区域，但却有四面墙。
 * 注意，防火墙只建立在两个不同区域的共享边界上。
 * <p>
 * 输入: isInfected = [[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]
 * 输出: 13
 * 解释: 在隔离右边感染区域后，隔离左边病毒区域只需要 2 个防火墙。
 *
 * @author : yixihan
 * @create : 2022-07-18-8:03
 */
public class Solution {

    int[][] isInfected;
    int m, n;
    int[] d = new int[]{0, 1, 0, -1, -1, 0, 1, 0};

    public int containVirus(int[][] isInfected) {
        this.isInfected = isInfected;
        this.m = isInfected.length;
        this.n = isInfected[0].length;
        int ans = 0;
        int wall = 0;
        do {
            if (wall != 0) {
                this.infect ();
            }
            wall = this.maxWall ();
            ans += wall;
        } while (wall != 0);
        return ans;
    }

    private int maxWall() {
        boolean[][] flag = new boolean[m][n];
        int maxm = -1, maxn = -1, wall = 0, refer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] refers = new boolean[m][n];
                int[] count = this.countWall (i, j, flag, refers);
                if (count[1] > refer) {
                    refer = count[1];
                    wall = count[0];
                    maxm = i;
                    maxn = j;
                }
            }
        }
        if (maxm != -1) {
            this.isolation (maxm, maxn);
        }
        return wall;
    }

    private void isolation(int x, int y) {
        this.isInfected[x][y] = 2;
        for (int i = 0; i < 8; i += 2) {
            int nextx = x + d[i], nexty = y + d[i + 1];
            if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n && this.isInfected[nextx][nexty] == 1) {
                this.isolation (nextx, nexty);
            }
        }
    }

    private int[] countWall(int x, int y, boolean[][] flag, boolean[][] refers) {
        int[] ans = new int[]{0, 0};
        if (flag[x][y] || this.isInfected[x][y] != 1) {
            return ans;
        }
        flag[x][y] = true;
        for (int i = 0; i < 8; i += 2) {
            int nextx = x + d[i], nexty = y + d[i + 1];
            if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n) {
                int next = this.isInfected[nextx][nexty];
                if (next == 0) {
                    ans[0] += 1;
                    if (!refers[nextx][nexty]) {
                        refers[nextx][nexty] = true;
                        ans[1] += 1;
                    }
                } else if (next == 1) {
                    int[] nextCount = this.countWall (nextx, nexty, flag, refers);
                    ans[0] += nextCount[0];
                    ans[1] += nextCount[1];
                }
            }
        }
        return ans;
    }

    private void infect() {
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.spread (i, j, flag);
            }
        }
    }

    private void spread(int x, int y, boolean[][] flag) {
        if (this.isInfected[x][y] != 1 || flag[x][y]) {
            return;
        }
        flag[x][y] = true;
        for (int i = 0; i < 8; i += 2) {
            int nextx = x + d[i], nexty = y + d[i + 1];
            if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n) {
                int next = this.isInfected[nextx][nexty];
                if (next == 0) {
                    flag[nextx][nexty] = true;
                    this.isInfected[nextx][nexty] = 1;
                } else {
                    this.spread (nextx, nexty, flag);
                }
            }
        }
    }
}

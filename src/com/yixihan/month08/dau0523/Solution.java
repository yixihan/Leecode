package com.yixihan.month08.dau0523;

import java.util.*;

/**
 * 你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中：
 * <p>
 * 0 表示障碍，无法触碰
 * 1 表示地面，可以行走
 * 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
 * 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。
 * <p>
 * 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
 * <p>
 * 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
 * <p>
 * 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。
 * <p>
 * 输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
 * 输出：6
 * 解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。
 * <p>
 * 输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
 * 输出：-1
 * 解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
 * <p>
 * 输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
 * 输出：6
 * 解释：可以按与示例 1 相同的路径来砍掉所有的树。
 * (0,0) 位置的树，可以直接砍去，不用算步数。
 *
 * @author : yixihan
 * @create : 2022-05-23-11:44
 */
public class Solution {

    int N = 50;
    int[][] g = new int[N][N];
    int n, m;
    List<int[]> list = new ArrayList<> ();

    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size ();
        m = forest.get (0).size ();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = forest.get (i).get (j);
                if (g[i][j] > 1) {
                    list.add (new int[]{g[i][j], i, j});
                }
            }
        }
        Collections.sort (list, Comparator.comparingInt (a -> a[0]));
        if (g[0][0] == 0) return -1;
        int x = 0, y = 0, ans = 0;
        for (int[] ne : list) {
            int nx = ne[1], ny = ne[2];
            int d = bfs (x, y, nx, ny);
            if (d == -1) {
                return -1;
            }
            ans += d;
            x = nx;
            y = ny;
        }
        return ans;
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int bfs(int X, int Y, int P, int Q) {
        if (X == P && Y == Q) return 0;
        boolean[][] vis = new boolean[n][m];
        Deque<int[]> d = new ArrayDeque<> ();
        d.addLast (new int[]{X, Y});
        vis[X][Y] = true;
        int ans = 0;
        while (!d.isEmpty ()) {
            int size = d.size ();
            while (size-- > 0) {
                int[] info = d.pollFirst ();
                int x = info[0], y = info[1];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if (g[nx][ny] == 0 || vis[nx][ny]) {
                        continue;
                    }
                    if (nx == P && ny == Q) {
                        return ans + 1;
                    }
                    d.addLast (new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}

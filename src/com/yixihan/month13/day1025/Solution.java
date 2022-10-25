package com.yixihan.month13.day1025;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * <p>
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * <p>
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * <p>
 * 返回必须翻转的 0 的最小数目。
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * <p>
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *
 * @author yixihan
 * @date 2022-10-25-17:37
 */
public class Solution {

    static int N = 10010;
    static int[] p = new int[N];
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int n;

    private int getIdx(int x, int y) {
        return x * n + y;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find (p[x]);
        }
        return p[x];
    }

    private void union(int x, int y) {
        p[find (x)] = p[find (y)];
    }

    public int shortestBridge(int[][] g) {
        n = g.length;
        for (int i = 0; i <= n * n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) {
                    continue;
                }
                for (int[] di : dirs) {
                    int x = i + di[0];
                    int y = j + di[1];
                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }
                    if (g[x][y] == 0) {
                        continue;
                    }
                    union (getIdx (i, j), getIdx (x, y));
                }
            }
        }
        int a = -1;
        int b = -1;
        Deque<int[]> d1 = new ArrayDeque<> ();
        Deque<int[]> d2 = new ArrayDeque<> ();
        Map<Integer, Integer> m1 = new HashMap<> ();
        Map<Integer, Integer> m2 = new HashMap<> ();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) {
                    continue;
                }
                int idx = getIdx (i, j);
                int root = find (idx);
                if (a == -1) {
                    a = root;
                } else if (a != root && b == -1) {
                    b = root;
                }
                if (root == a) {
                    d1.addLast (new int[]{i, j});
                    m1.put (idx, 0);
                } else if (root == b) {
                    d2.addLast (new int[]{i, j});
                    m2.put (idx, 0);
                }
            }
        }
        while (!d1.isEmpty () && !d2.isEmpty ()) {
            int t = -1;
            if (d1.size () < d2.size ()) {
                t = update (d1, m1, m2);
            } else {
                t = update (d2, m2, m1);
            }
            if (t != -1) {
                return t - 1;
            }
        }
        return -1; // never
    }

    int update(Deque<int[]> d, Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
        int sz = d.size ();
        while (sz-- > 0) {
            int[] info = d.pollFirst ();
            int x = info[0];
            int y = info[1];
            int idx = getIdx (x, y);
            int step = m1.get (idx);
            for (int[] di : dirs) {
                int nx = x + di[0];
                int ny = y + di[1];
                int nidx = getIdx (nx, ny);
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (m1.containsKey (nidx)) {
                    continue;
                }
                if (m2.containsKey (nidx)) {
                    return step + 1 + m2.get (nidx);
                }
                d.addLast (new int[]{nx, ny});
                m1.put (nidx, step + 1);
            }
        }
        return -1;
    }
}

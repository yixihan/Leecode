package com.yixihan.month04.day0208;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。
 * <p>
 * 给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 的灯。
 * 即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。
 * <p>
 * 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。
 * <p>
 * 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。
 * 对于第 j 个查询，如果单元格 [rowj, colj] 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，
 * 关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。
 * <p>
 * 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。
 * <p>
 * 输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * 输出：[1,0]
 * 解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）。
 * 该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
 * <p>
 * 第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
 * <p>
 * <p>
 * 输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
 * 输出：[1,1]
 * <p>
 * 输入：n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
 * 输出：[1,1,0]
 *
 * @author : yixihan
 * @create : 2022-02-08-9:34
 */
public class Solution {

    private static final int[][] dirs = new int[][]{{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}};

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        long N = n;
        Map<Integer, Integer> row = new HashMap<> ();
        Map<Integer, Integer> col = new HashMap<> ();
        Map<Integer, Integer> left = new HashMap<> ();
        Map<Integer, Integer> right = new HashMap<> ();
        Set<Long> set = new HashSet<> ();

        for (int[] l : lamps) {
            int x = l[0];
            int y = l[1];
            int a = x + y;
            int b = x - y;
            if (set.contains (x * N + y)) {
                continue;
            }
            increment (row, x);
            increment (col, y);
            increment (left, a);
            increment (right, b);
            set.add (x * N + y);
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            int a = x + y;
            int b = x - y;

            if (row.containsKey (x) || col.containsKey (y) || left.containsKey (a) || right.containsKey (b)) {
                ans[i] = 1;
            }

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                int na = nx + ny;
                int nb = nx - ny;

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (set.contains (nx * N + ny)) {
                    set.remove (nx * N + ny);
                    decrement (row, nx);
                    decrement (col, ny);
                    decrement (left, na);
                    decrement (right, nb);
                }
            }
        }
        return ans;
    }

    private void increment(Map<Integer, Integer> map, int key) {
        map.put (key, map.getOrDefault (key, 0) + 1);
    }

    private void decrement(Map<Integer, Integer> map, int key) {
        if (map.get (key) == 1) map.remove (key);
        else map.put (key, map.get (key) - 1);
    }
}

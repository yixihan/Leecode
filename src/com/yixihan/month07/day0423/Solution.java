package com.yixihan.month07.day0423;

import java.util.Arrays;

/**
 * 在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。
 * 只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 * <p>
 * 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * 输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * 解释:
 * <p>
 * <p>
 * 输入: [[1,2],[2,2],[4,2]]
 * 输出: [[1,2],[2,2],[4,2]]
 * 解释:
 * <p>
 * 即使树都在一条直线上，你也需要先用绳子包围它们。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/erect-the-fence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : yixihan
 * @create : 2022-04-23-13:01
 */
public class Solution {

    public int[][] outerTrees(int[][] trees) {
        Arrays.sort (trees, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int n = trees.length, tp = 0;
        int[] stk = new int[n + 10];
        boolean[] vis = new boolean[n + 10];
        stk[++tp] = 0; // 不标记起点
        for (int i = 1; i < n; i++) {
            int[] c = trees[i];
            while (tp >= 2) {
                int[] a = trees[stk[tp - 1]];
                int[] b = trees[stk[tp]];
                if (getArea (a, b, c) < 0) {
                    vis[stk[tp--]] = false;
                } else {
                    break;
                }
            }
            stk[++tp] = i;
            vis[i] = true;
        }
        int size = tp;
        for (int i = n - 1; i >= 0; i--) {
            if (vis[i]) {
                continue;
            }
            int[] c = trees[i];
            while (tp > size) {
                int[] a = trees[stk[tp - 1]];
                int[] b = trees[stk[tp]];
                if (getArea (a, b, c) < 0) {
                    tp--;
                }
                // vis[stk[tp--]] = false; // 非必须
                else {
                    break;
                }
            }
            stk[++tp] = i;
            // vis[i] = true; // 非必须
        }
        int[][] ans = new int[tp - 1][2];
        for (int i = 1; i < tp; i++) {
            ans[i - 1] = trees[stk[i]];
        }
        return ans;
    }

    private int[] subtraction(int[] a, int[] b) { // 向量相减
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }

    private double cross(int[] a, int[] b) { // 叉乘
        return a[0] * b[1] - a[1] * b[0];
    }

    private double getArea(int[] a, int[] b, int[] c) { // 向量 ab 转为 向量 ac 过程中扫过的面积
        return cross (subtraction (b, a), subtraction (c, a));
    }
}

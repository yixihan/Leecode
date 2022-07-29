package com.yixihan.month10.day0729;

/**
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 * <p>
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 * <p>
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 * <p>
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * <p>
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * <p>
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-07-29-12:56
 */
public class Solution {

    long len = -1;

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return calc (p1, p2, p3) && calc (p1, p2, p4) && calc (p1, p3, p4) && calc (p2, p3, p4);
    }

    boolean calc(int[] a, int[] b, int[] c) {
        long l1 = (long) (a[0] - b[0]) * (a[0] - b[0]) + (long) (a[1] - b[1]) * (a[1] - b[1]);
        long l2 = (long) (a[0] - c[0]) * (a[0] - c[0]) + (long) (a[1] - c[1]) * (a[1] - c[1]);
        long l3 = (long) (b[0] - c[0]) * (b[0] - c[0]) + (long) (b[1] - c[1]) * (b[1] - c[1]);
        boolean ok = (l1 == l2 && l1 + l2 == l3) || (l1 == l3 && l1 + l3 == l2) || (l2 == l3 && l2 + l3 == l1);
        if (!ok) {
            return false;
        }
        if (len == -1) {
            len = Math.min (l1, l2);
        } else if (len == 0 || len != Math.min (l1, l2)) {
            return false;
        }
        return true;
    }
}

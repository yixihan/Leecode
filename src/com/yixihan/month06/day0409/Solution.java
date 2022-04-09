package com.yixihan.month06.day0409;

/**
 * 给定四个整数 sx , sy ，tx 和 ty，
 * 如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
 * <p>
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 * <p>
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: true
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * <p>
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: false
 * <p>
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: true
 *
 * @author : yixihan
 * @create : 2022-04-09-12:59
 */
public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > 0 && ty > 0) {
            if (sx == tx && sy == ty) {
                return true;
            }

            if (ty > tx) {
                // tx - sx 是目标与起始值在x的差距，我们需要一次减去 n * ty 达到快速逼近 sx 的目的
                // (ty - sy) / tx = n
                ty -= Math.max ((ty - sy) / tx, 1) * tx;
            } else {
                tx -= Math.max ((tx - sx) / ty, 1) * ty;
            }
        }

        return false;
    }
}

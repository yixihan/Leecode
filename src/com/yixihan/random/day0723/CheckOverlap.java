package com.yixihan.random.day0723;

/**
 * 给你一个以 (radius, x_center, y_center) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2)，
 * 其中 (x1, y1) 是矩形左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果圆和矩形有重叠的部分，请你返回 True ，否则返回 False 。
 * <p>
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 * <p>
 * 输入：radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * 解释：圆和矩形有公共点 (1,0)
 * <p>
 * 输入：radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * 输出：true
 * <p>
 * 输入：radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3
 * 输出：true
 * <p>
 * 输入：radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-07-23-12:49
 */
public class CheckOverlap {

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // 圆心在矩形内
        if (xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2) {
            return true;
        }

        int yp = yCenter < y1 ? y1 : Math.min (y2, yCenter);
        int xp = xCenter < x1 ? x1 : Math.min (x2, xCenter);

        return Math.pow (xp - xCenter, 2) + Math.pow (yp - yCenter, 2) <= radius * radius;
    }
}

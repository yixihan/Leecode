package com.yixihan.month02.day1116;

import java.util.*;


/**
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 *
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 *
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
 * 输出：false
 * 解释：图形顶端留有空缺，无法覆盖成一个矩形。
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 *
 *
 * @author : yixihan
 * @create : 2021-11-16-10:29
 */
public class RectangleCover {


    public boolean isRectangleCover(int[][] rectangles) {

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;

        int n = rectangles.length;

        Set<String> set = new HashSet<>();
        int sumArea = 0;

        for (int[] rectangle : rectangles) {

            // 获取四个点的坐标
            left = Math.min(left, rectangle[0]);
            bottom = Math.min(bottom, rectangle[1]);
            right = Math.max(right, rectangle[2]);
            top = Math.max(top, rectangle[3]);

            // 计算总小矩形的面积
            sumArea += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);

            // 分别记录小矩形的坐标
            String lt = rectangle[0] + " " + rectangle[3];
            String lb = rectangle[0] + " " + rectangle[1];
            String rt = rectangle[2] + " " + rectangle[3];
            String rb = rectangle[2] + " " + rectangle[1];

            // 如果有就移除, 没有就加入
            if (!set.contains(lt)) {
                set.add(lt);
            } else {
                set.remove(lt);
            }

            if (!set.contains(lb)) {
                set.add(lb);
            } else {
                set.remove(lb);
            }

            if (!set.contains(rt)) {
                set.add(rt);
            } else {
                set.remove(rt);
            }

            if (!set.contains(rb)) {
                set.add(rb);
            } else {
                set.remove(rb);
            }
        }

        // 最后只剩 4 个大矩形坐标且面积相等即为完美矩形
        if (set.size() == 4 && set.contains(left + " " + top) &&
                set.contains(left + " " + bottom) && set.contains(right + " " + bottom) &&
                set.contains(right + " " + top)) {
            return sumArea == (right - left) * (top - bottom);
        }
        return false;
    }

}

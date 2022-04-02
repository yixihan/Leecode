package com.yixihan.month02.day1125;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。
 *
 * 如果没有任何矩形，就返回 0。
 *
 * 输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
 * 输出：4
 *
 * 输入：[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2021-11-25-12:50
 */
public class MinAreaRect {

    /**
     * 1 <= points.length <= 500
     * 0 <= points[i][0] <= 40000
     * 0 <= points[i][1] <= 40000
     */
    public int minAreaRect(int[][] points) {

        Set<Integer> set = new HashSet<>();

        int res = Integer.MAX_VALUE;
        final int MAX = 40000;

        for (int[] point : points) {
            for (int[] anotherPoint : points) {

                if (point[0] == anotherPoint[0] || point[1] == anotherPoint[1]) {
                    continue;
                }

                if (set.contains(point[0] * MAX + anotherPoint[1])
                        && set.contains(anotherPoint[0] * MAX + point[1])) {

                    res = Math.min(res,
                            Math.abs((point[0] - anotherPoint[0]) * (point[1] - anotherPoint[1])));
                }
            }
            set.add(point[0] * MAX + point[1]);
        }

        return res == Integer.MAX_VALUE ? 0 :res;
    }
}

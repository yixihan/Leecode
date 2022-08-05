package com.yixihan.random.day0805;

import java.util.*;

/**
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直面积 的宽度。
 * <p>
 * 垂直面积 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积 为宽度最大的一个垂直面积。
 * <p>
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * <p>
 * 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出：1
 * 解释：红色区域和蓝色区域都是最优区域。
 * <p>
 * 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-08-05-13:14
 */
public class MaxWidthOfVerticalArea {

    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> set = new HashSet<> ();

        for (int[] point : points) {
            set.add (point[0]);
        }

        List<Integer> list = new ArrayList<> (set);
        Collections.sort (list);
        int ans = 0;
        for (int i = 1; i < list.size (); i++) {
            ans = Math.max (ans, list.get (i) - list.get (i - 1));
        }

        return ans;
    }
}

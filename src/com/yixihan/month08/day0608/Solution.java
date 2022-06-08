package com.yixihan.month08.day0608;

/**
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 * <p>
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 * <p>
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-06-08-14:16
 */
public class Solution {

    /**
     * 计算三点形成的三角形面积是否为零即可
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {

        return (points[0][0] * points[1][1] - points[1][0] * points[0][1]) + (points[1][0] * points[2][1] - points[2][0] * points[1][1]) + (points[2][0] * points[0][1] - points[0][0] * points[2][1]) != 0;
    }

}

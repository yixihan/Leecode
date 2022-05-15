package com.yixihan.month07.day0515;

/**
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * <p>
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * <p>
 * 注意:
 * <p>
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 * -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 *
 * @author : yixihan
 * @create : 2022-05-15-8:51
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = Double.MIN_VALUE;
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                for (int k = j + 1; k < points.length; ++k) {
                    double area = 0.5 * Math.abs ((points[i][0] - points[k][0]) * (points[j][1] - points[k][1]) - (points[j][0] - points[k][0]) * (points[i][1] - points[k][1]));
                    res = Math.max (res, area);
                }
            }
        }
        return res;
    }
}

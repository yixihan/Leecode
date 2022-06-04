package com.yixihan.month08.day0605;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 *
 * 实现 Solution 类:
 *
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 *
 * 输入: 
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 * 解释:
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint ();//返回[-0.02493，-0.38077]
 * solution.randPoint ();//返回[0.82314,0.38945]
 * solution.randPoint ();//返回[0.36572,0.17248]
 *
 * @author : yixihan
 * @create : 2022-06-05-7:00
 */
public class Solution {

    double x;
    double y;
    double r;
    Random rd = new Random ();

    public Solution(double radius, double x_center, double y_center) {
        x = x_center;
        y = y_center;
        r = radius;
    }

    public double[] randPoint() {

        double len = Math.sqrt (rd.nextDouble () * (r * r));
        int angle = rd.nextInt (361);
        double ras1 = Math.sin (angle) * len;
        double ras2 = Math.cos (angle) * len;

        return new double[]{ras1 + x, ras2 + y};
    }

    static class Main {
        public static void main(String[] args) {
            new Solution (5.2, 0.0, 0.0).randPoint ();
        }
    }
}

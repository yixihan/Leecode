package com.yixihan.month13.day1104;

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 你可以做一些数量的移动 numMoves :
 * <p>
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 *
 * @author yixihan
 * @date 2022/11/4 9:08
 */
public class Solution {

    public int reachNumber(int target) {
        int t = Math.abs (target);
        int s = 0;
        int dis = 0;

        while (dis < t) {
            s++;
            dis += s;

        }

        int dt = dis - t;
        return dt % 2 == 0 ? s : s % 2 == 0 ? s + 1 : s + 2;
    }
}

package com.yixihan.month08.day0609;

import java.util.Random;

/**
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * <p>
 * 在一个给定的矩形覆盖的空间内任何整数点都有可能被返回。
 * <p>
 * 请注意 ，整数点是具有整数坐标的点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2, -2, 1, 1], [2, 2, 4, 6]]],[],[],[],[],[]]
 * 输出:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]
 * <p>
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 *
 * @author : yixihan
 * @create : 2022-06-09-9:00
 */
public class Solution {

    int[][] rects;
    Random rd = new Random ();

    public Solution(int[][] rects) {
        this.rects = rects;
    }

    public int[] pick() {
        int curSum = 0;
        int index = 0;

        for (int i = 0; i < rects.length; i++) {
            int cur = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            curSum += cur;

            if (rd.nextInt (curSum) < cur) {
                index = i;
            }
        }

        return new int[]{(rects[index][0] + rd.nextInt (rects[index][2] - rects[index][0] + 1)), rects[index][1] + rd.nextInt (rects[index][3] - rects[index][1] + 1)};

    }
}

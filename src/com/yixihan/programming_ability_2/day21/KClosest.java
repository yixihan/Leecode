package com.yixihan.programming_ability_2.day21;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，
 * 并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
 * <p>
 * 这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
 * <p>
 * 你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
 * <p>
 * 输入：points = [[1,3],[-2,2]], k = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], k = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 * @author : yixihan
 * @create : 2022-04-13-13:23
 */
public class KClosest {

    public int[][] kClosest(int[][] points, int k) {

        int[][] ans = new int[k][2];
        Queue<int[]> queue = new PriorityQueue<> ((o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);

        queue.addAll (Arrays.asList (points));
        int index = 0;

        while (!queue.isEmpty () && index < k) {
            int[] point = queue.poll ();
            ans[index++] = point;
        }

        return ans;
    }
}

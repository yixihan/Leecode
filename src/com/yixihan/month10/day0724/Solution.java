package com.yixihan.month10.day0724;

/**
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * <p>
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * <p>
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 * <p>
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 *
 * @author : yixihan
 * @create : 2022-07-24-8:45
 */
public class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int d1 = 0;
        int d2 = 0;
        int min = Math.min (start, destination);
        int max = Math.max (start, destination);

        for (int i = 0; i < distance.length; i++) {
            if (i >= min && i < max) {
                d1 += distance[i];
            } else {
                d2 += distance[i];
            }
        }

        return Math.min (d1, d2);
    }
}

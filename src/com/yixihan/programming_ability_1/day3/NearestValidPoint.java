package com.yixihan.programming_ability_1.day3;

/**
 * 给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。
 * 同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点。
 * 当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 *
 * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。
 * 如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 *
 * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 *
 *
 * 输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * 输出：2
 * 解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。
 * 有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
 *
 * 输入：x = 3, y = 4, points = [[3,4]]
 * 输出：0
 * 提示：答案可以与你当前所在位置坐标相同。
 *
 * 输入：x = 3, y = 4, points = [[2,3]]
 * 输出：-1
 * 解释：没有 有效点。
 *
 * @author : yixihan
 * @create : 2022-03-13-10:20
 */
public class NearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {

        // 方法一 : 暴力解法
//        List<int[]> list = new ArrayList<> ();
//
//        for (int i = 0; i < points.length; i++) {
//            if (points[i][0] == x || points[i][1] == y) {
//                list.add (new int[]{i, (Math.abs (x - points[i][0] + Math.abs (y - points[i][1]))), points[i][0], points[i][1]});
//            }
//        }
//
//        if (list.size () == 0) {
//            return -1;
//        }
//
//        list.sort ((o1, o2) -> {
//            if (o1[1] == o2[1]) {
//                return o1[2] + o1[3] - o2[2] - o2[3];
//            } else {
//                return o1[1] - o2[1];
//            }
//        });
//
//        return list.get (0)[0];

        // 方法二 : 还是暴力解法, 但是时间复杂度低一点儿
        int minIndex = -1;
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dis = Math.abs (x - points[i][0] + Math.abs (y - points[i][1]));
                if (minDis > dis) {
                    minDis = dis;
                    minIndex = i;
                } else if (minDis == dis) {
                    minIndex = Math.min (minIndex, i);
                }
            }
        }

        return minIndex;

    }
}

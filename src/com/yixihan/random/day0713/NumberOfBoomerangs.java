package com.yixihan.random.day0713;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * <p>
 * 输入：points = [[1,1]]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-07-13-9:22
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int disX = points[i][0] - points[j][0];
                int disY = points[i][1] - points[j][1];
                int dis = disX * disX + disY * disY;
                if (!map.containsKey (dis)) {
                    map.put (dis, 1);
                } else {
                    int tmp = map.get (dis);
                    ans += 2 * tmp;
                    map.put (dis, tmp + 1);
                }
            }
            map.clear();
        }

        return ans;
    }
}

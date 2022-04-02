package com.yixihan.month04.day0126;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
 *
 * 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
 * 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
 * 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
 *
 * 实现 DetectSquares 类：
 *
 * DetectSquares() 使用空数据结构初始化对象
 * void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
 * int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。
 *
 * 输入：
 * ["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
 * [[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
 * 输出：
 * [null, null, null, null, 1, 0, null, 2]
 *
 * 解释：
 * DetectSquares detectSquares = new DetectSquares();
 * detectSquares.add([3, 10]);
 * detectSquares.add([11, 2]);
 * detectSquares.add([3, 2]);
 * detectSquares.count([11, 10]); // 返回 1 。你可以选择：
 *                                //   - 第一个，第二个，和第三个点
 * detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
 * detectSquares.add([11, 2]);    // 允许添加重复的点。
 * detectSquares.count([11, 10]); // 返回 2 。你可以选择：
 *                                //   - 第一个，第二个，和第三个点
 *                                //   - 第一个，第三个，和第四个点
 *
 * @author : yixihan
 * @create : 2022-01-26-8:35
 */
public class DetectSquares {

    Map<Integer, Map<Integer, Integer>> xMap;
    Map<Integer, Map<Integer, Integer>> yMap;

    public DetectSquares() {
        xMap = new HashMap<>();
        yMap = new HashMap<>();

    }

    public void add(int[] point) {
        Map<Integer, Integer> x = xMap.getOrDefault (point[0], new HashMap<> ());
        x.put (point[1], x.getOrDefault (point[1], 0) + 1);
        xMap.put (point[0], x);

        Map<Integer, Integer> y = yMap.getOrDefault (point[1], new HashMap<> ());
        y.put (point[0], y.getOrDefault (point[0], 0) + 1);
        yMap.put (point[1], y);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;
        // find a point b(x + ?, y)
        if (!yMap.containsKey(y)) return 0;
        Map<Integer, Integer> sameY = yMap.get (y);
        // iterating all b points
        for (Integer bX : sameY.keySet()) {
            int bCount = sameY.get(bX);
            int d = bX - x;
            if (d != 0) {
                // find c
                if (!xMap.containsKey(x)) continue;
                Map<Integer, Integer> sameX = xMap.get (x);
                if (sameX.containsKey(y - d)) {
                    // find d
                    if (xMap.get(bX) != null && xMap.get(bX).containsKey(y - d)) {
                        int cCount = sameX.get(y - d);
                        int dCount = xMap.get(bX).get(y - d);
                        ans += cCount * dCount * bCount;
                    }
                }
                if (sameX.containsKey(y + d)) {
                    // find d
                    if (xMap.get(bX) != null && xMap.get(bX).containsKey(y + d)) {
                        int cCount = sameX.get(y + d);
                        int dCount = xMap.get(bX).get(y + d);
                        ans += cCount * dCount * bCount;
                    }
                }
            }
        }
        return ans;
    }
}

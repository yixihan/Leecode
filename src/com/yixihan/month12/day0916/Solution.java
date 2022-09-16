package com.yixihan.month12.day0916;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 我们给出了一个（轴对齐的）二维矩形列表 rectangles 。
 * 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形 i 左下角的坐标，
 * (xi1, yi1) 是该矩形 左下角 的坐标， (xi2, yi2) 是该矩形 右上角 的坐标。
 * <p>
 * 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。
 * <p>
 * 返回 总面积 。因为答案可能太大，返回 109 + 7 的 模 。
 * <p>
 * 输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
 * 输出：6
 * 解释：如图所示，三个矩形覆盖了总面积为6的区域。
 * 从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
 * 从(1,0)到(2,3)，三个矩形都重叠。
 * <p>
 * 输入：rectangles = [[0,0,1000000000,1000000000]]
 * 输出：49
 * 解释：答案是 1018 对 (109 + 7) 取模的结果， 即 49 。
 *
 * @author : yixihan
 * @create : 2022-09-16-15:58
 */
public class Solution {

    int mod = (int) 1e9 + 7;

    public int rectangleArea(int[][] rectangles) {
        int[] map1 = compress (rectangles, 0, 2);
        int[] map2 = compress (rectangles, 1, 3);
        long ans = 0;
        for (int i = 0; i < map1.length - 1; i++) {
            int[] count = new int[map2.length + 5];
            for (int[] rectangle : rectangles) {
                if (i >= rectangle[0] && i < rectangle[2]) {
                    count[rectangle[1]]++;
                    count[rectangle[3]]--;
                }
            }
            long d = map1[i + 1] - map1[i];
            if (count[0] > 0) {
                ans += d * (map2[1] - map2[0]);
            }
            for (int j = 1; j < map2.length; j++) {
                count[j] += count[j - 1];
                if (count[j] > 0) {
                    ans += d * (map2[j + 1] - map2[j]);
                }
            }
        }
        return (int) (ans % mod);
    }

    private int[] compress(int[][] r, int idx1, int idx2) {
        TreeSet<Integer> set = new TreeSet<> ();
        for (int[] ints : r) {
            set.add (ints[idx1]);
            set.add (ints[idx2]);
        }
        Map<Integer, Integer> map = new HashMap<> ();
        int[] ans = new int[set.size ()];
        int p = 0;
        for (int a : set) {
            ans[p] = a;
            map.put (a, p);
            p++;
        }
        for (int i = 0; i < r.length; i++) {
            r[i][idx1] = map.get (r[i][idx1]);
            r[i][idx2] = map.get (r[i][idx2]);
        }
        return ans;
    }
}

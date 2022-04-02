package com.yixihan.data_structure_2.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author : yixihan
 * @create : 2022-03-25-14:45
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<> ();

        Arrays.sort (intervals, Comparator.comparingInt (o -> o[0]));

        int n = intervals.length;
        boolean[] visited = new boolean[n];
        int start;
        int end;

        for (int i = 0; i < n; i++) {

            if (visited[i]) {
                continue;
            }
            start = intervals[i][0];
            end = intervals[i][1];
            visited[i] = true;

            for (int j = i + 1; j < n; j++) {
                if (end >= intervals[j][0]) {
                    end = Math.max (intervals[j][1], end);
                    visited[j] = true;
                } else {
                    i = j - 1;
                    break;
                }
            }

            ans.add (new int[]{start, end});
        }

        return ans.toArray (new int[0][]);
    }
}

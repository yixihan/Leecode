package com.yixihan.binary_2.day11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * <p>
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>
 * <p>
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * <p>
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 *
 * @author : yixihan
 * @create : 2022-05-19-15:27
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        for (int i = 0; i < n; ++i) {
            intervals[i] = new int[]{intervals[i][0], intervals[i][1], i};
        }

        Arrays.sort (intervals, Comparator.comparingInt (o -> o[0]));
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            int low = i;
            int high = n - 1;
            int tar = intervals[i][1];
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (intervals[mid][0] >= tar) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans[intervals[i][2]] = low == n ? -1 : intervals[low][2];
        }
        return ans;
    }
}

package com.yixihan.data_structure_2.day4;

import java.util.Arrays;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * <p>
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @author : yixihan
 * @create : 2022-03-27-8:23
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort (intervals, (o1, o2) -> {
            return o1[0] == o2[0] ? (o1[1] - o1[0]) - (o2[1] - o2[0]) : o1[0] - o2[0];
        });


        int n = intervals.length;
        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int end = intervals[i][1];

            for (int j = i + 1; j < n; j++) {
                if (!visited[j] && end > intervals[j][0]) {
                    // System.out.println ("j = " + j + ", i = " + i + ", end = " + end + ", intervals[j][0] = " + intervals[j][0]);
                    if (end < intervals[j][1]) {
                        visited[j] = true;
                        // System.out.println ("j置为true");
                    } else {
                        visited[i] = true;
                        // System.out.println ("i置为true");
                        break;
                    }
                } else {
                    break;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            // System.out.println (Arrays.toString (intervals[i]) + ", " + visited[i]);
            ans += visited[i] ? 1 : 0;
        }

        return ans;
    }
}

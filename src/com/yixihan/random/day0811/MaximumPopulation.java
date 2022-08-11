package com.yixihan.random.day0811;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * <p>
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。
 * 第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * <p>
 * 返回 人口最多 且 最早 的年份。
 * <p>
 * 输入：logs = [[1993,1999],[2000,2010]]
 * 输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 * <p>
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出：1960
 * 解释：
 * 人口最多为 2 ，分别出现在 1960 和 1970 。
 * 其中最早年份是 1960 。
 *
 * @author : yixihan
 * @create : 2022-08-11-9:11
 */
public class MaximumPopulation {

    public int maximumPopulation(int[][] logs) {
        Arrays.sort (logs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int minYear = Integer.MAX_VALUE;
        int maxCnt = Integer.MIN_VALUE;

        for (int[] log : logs) {
            int cnt = 0;
            int year = log[0];

            for (int j = 0; j < logs.length; j++) {
                if (year >= logs[j][0] && year < logs[j][1]) {
                    cnt++;
                }
            }

            if (maxCnt == cnt) {
                minYear = Math.min (year, minYear);
            } else if (maxCnt < cnt) {
                maxCnt = cnt;
                minYear = year;
            }

        }

        return minYear;
    }
}

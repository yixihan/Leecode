package com.yixihan.month04.day0118;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-01-18-6:48
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minDifference = Integer.MAX_VALUE;

        int[] differences = new int[timePoints.size ()];

        for (int i = 0; i < differences.length; i++) {
            differences[i] = Integer.parseInt (timePoints.get (i).substring (0, 2)) * 60 +
                    Integer.parseInt (timePoints.get (i).substring (3));
        }

        Arrays.sort (differences);

        for (int i = 1; i < differences.length; i++) {
            minDifference = Math.min (minDifference, differences[i] - differences[i - 1]);
        }


        return Math.min (minDifference, differences[0] + 1440 - differences[differences.length - 1]);
    }
}

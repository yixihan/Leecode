package com.yixihan.random.day0721;

import java.util.*;
import java.util.function.Predicate;

/**
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *
 * @author : yixihan
 * @create : 2022-07-21-10:09
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort (intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int delete = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= pre) {
                delete++;
            } else {
                pre = intervals[i][1];
            }
        }

        return intervals.length - delete;
    }
}

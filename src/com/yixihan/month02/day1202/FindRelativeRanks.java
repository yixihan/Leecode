package com.yixihan.month02.day1202;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 *
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 *
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 * @author : yixihan
 * @create : 2021-12-02-0:07
 */
public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score) {

        int length = score.length;
        String[] result = new String[length];
        int[] clone = score.clone ();
        Map<Integer, String> map = new HashMap<>();

        Arrays.sort (clone);

        for (int i = clone.length - 1; i >= 0; i--) {
            if (i == clone.length - 1) {
                map.put (clone[i], "Gold Medal");
            } else if (i == clone.length - 2) {
                map.put (clone[i], "Silver Medal");
            } else if (i == clone.length - 3) {
                map.put (clone[i], "Bronze Medal");
            } else {
                map.put (clone[i], String.valueOf (clone.length - i));
            }
        }

        for (int i = 0; i < score.length; i++) {
            result[i] = map.get (score[i]);
        }

        return result;
    }
}

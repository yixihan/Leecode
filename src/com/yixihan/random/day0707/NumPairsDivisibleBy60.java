package com.yixihan.random.day0707;

import java.util.HashMap;
import java.util.Map;

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 *
 * @author : yixihan
 * @create : 2022-07-07-8:11
 */
public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<> ();

        for (int val : time) {
            int key = val % 60 == 0 ? 0 : 60 - (val % 60);
            if (map.containsKey (val % 60)) {
                ans += map.get (val % 60);
            }
            map.put (key, map.getOrDefault (key, 0) + 1);
        }

        return ans;
    }
}

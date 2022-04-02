package com.yixihan.month04.day0206;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 *
 * 请你返回 nums 中唯一元素的 和 。
 *
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 * @author : yixihan
 * @create : 2022-02-06-12:15
 */
public class SumOfUnique {
    public int sumOfUnique(int[] nums) {

        // 解法一
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put (num, map.getOrDefault (num, 0) + 1);
//        }
//
//        int ans = 0;
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
//            if (entry.getValue () == 1) {
//                ans += entry.getKey ();
//            }
//        }
//
//        return ans;


        // 解法二
        int[] cnt = new int[110];

        for (int num : nums) {
            cnt[num]++;
        }

        int ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                ans += i;
            }
        }

        return ans;
    }
}

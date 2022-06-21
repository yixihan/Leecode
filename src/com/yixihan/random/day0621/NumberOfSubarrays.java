package com.yixihan.random.day0621;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中 「优美子数组」 的数目。
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * @author : yixihan
 * @create : 2022-06-21-10:30
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        Map<Long, Integer> map = new HashMap<> ();
        map.put (0L, 1);
        long sum = 0;

        for (int num : nums) {
            sum += num % 2 == 0 ? 0 : 1;
            if (map.containsKey (sum - k)) {
                ans += map.get (sum - k);
            }
            map.put (sum, map.getOrDefault (sum, 0) + 1);
        }

        return ans;
    }
}

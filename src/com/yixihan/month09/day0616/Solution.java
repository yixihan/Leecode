package com.yixihan.month09.day0616;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * <p>
 * 这里将 k-diff  数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * <p>
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 * <p>
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * <p>
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * <p>
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 *
 * @author : yixihan
 * @create : 2022-06-16-10:40
 */
public class Solution {

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<> ();
        int count = 0;
        for (int num : nums) {
            map.putIfAbsent (num, 0);
            map.put (num, map.get (num) + 1);
        }
        for (int i : map.keySet ()) {
            if (k == 0) {
                if (map.get (i) > 1) {
                    count++;
                }
            } else if (map.containsKey (i + k)) {
                count++;
            }
        }
        return count;
    }
}

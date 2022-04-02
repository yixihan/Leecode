package com.yixihan.month03.day0112;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 *
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 *
 * @author : yixihan
 * @create : 2022-01-12-6:32
 */
public class Solution {

    public boolean increasingTriplet(int[] nums) {

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= minValue) {
                minValue = num;
            } else if (num <= maxValue) {
                maxValue = num;
            } else {
                return true;
            }
        }

        return false;
    }
}

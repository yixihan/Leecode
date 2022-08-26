package com.yixihan.month11.day0826;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * <p>
 * 请你计算并返回该式的最大值。
 * <p>
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * <p>
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * <p>
 * 输入：nums = [3,7]
 * 输出：12
 *
 * @author : yixihan
 * @create : 2022-08-26-12:51
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE + 1;

        for (int num : nums) {
            if (num > secondMax) {
                firstMax = secondMax;
                secondMax = num;
            } else if (num > firstMax) {
                firstMax = num;
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }
}

package com.yixihan.month14.day1116;

/**
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 * <p>
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 * <p>
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 * <p>
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 * <p>
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：false
 * 解释：有 2 个全局倒置，和 1 个局部倒置。
 *
 * @author yixihan
 * @date 2022/11/16 10:48
 */
public class Solution {

    // 审题!数列排序后就就是0,1,2.......N,刚好和下标是对应的.如果一个数和他的下标偏移量超过了1,即是和他的有序排列偏移超过了1,那么全局偏移和局部偏移必然不相等
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && Math.abs (nums[i] - i) > 1) {
                return false;
            }
        }

        return true;
    }
}

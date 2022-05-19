package com.yixihan.month08.day0519;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 *
 * @author : yixihan
 * @create : 2022-05-19-15:07
 */
public class Solution {

    public int minMoves2(int[] nums) {
        Arrays.sort (nums);

        int n = nums.length;

        return getAns (nums, nums[n / 2]);


    }

    private int getAns(int[] nums, int val) {
        int ans = 0;

        for (int num : nums) {
            ans += Math.abs (num - val);
        }

        return ans;
    }
}

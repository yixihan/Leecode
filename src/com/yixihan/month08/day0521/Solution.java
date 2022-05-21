package com.yixihan.month08.day0521;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * <p>
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * <p>
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * @author : yixihan
 * @create : 2022-05-21-13:54
 */
public class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort (nums);
        return nums[nums.length / 2] == nums[nums.length - 1] ? nums[nums.length / 2] : nums[nums.length / 2 - 1];
    }
}

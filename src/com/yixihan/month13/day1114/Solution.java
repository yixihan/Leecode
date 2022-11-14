package com.yixihan.month13.day1114;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定你一个整数数组nums
 * <p>
 * 我们要将nums数组中的每个元素移动到A数组 或者B数组中，使得A数组和B数组不为空，并且average(A) == average(B)。
 * <p>
 * 如果可以完成则返回true， 否则返回 false。
 * <p>
 * 注意：对于数组arr, average(arr)是arr的所有元素除以arr长度的和。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7,8]
 * 输出: true
 * 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 * <p>
 * 输入: nums = [3,1]
 * 输出: false
 *
 * @author yixihan
 * @date 2022/11/14 9:29
 */
public class Solution {

    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return false;
        }
        int s = Arrays.stream (nums).sum ();
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i] * n - s;
        }
        int m = n >> 1;
        Set<Integer> vis = new HashSet<> ();
        for (int i = 1; i < 1 << m; ++i) {
            int t = 0;
            for (int j = 0; j < m; ++j) {
                if (((i >> j) & 1) == 1) {
                    t += nums[j];
                }
            }
            if (t == 0) {
                return true;
            }
            vis.add (t);
        }
        for (int i = 1; i < 1 << (n - m); ++i) {
            int t = 0;
            for (int j = 0; j < (n - m); ++j) {
                if (((i >> j) & 1) == 1) {
                    t += nums[m + j];
                }
            }
            if (t == 0 || (i != (1 << (n - m)) - 1) && vis.contains (-t)) {
                return true;
            }
        }
        return false;
    }
}

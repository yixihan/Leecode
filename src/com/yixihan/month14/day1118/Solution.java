package com.yixihan.month14.day1118;

import java.util.Arrays;

/**
 * 一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
 * <p>
 * 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 109 + 7 取余 后的结果。
 * <p>
 * 子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
 * <p>
 * 输入：nums = [2,1,3]
 * 输出：6
 * 解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
 * 相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
 * 宽度之和是 6 。
 * <p>
 * 输入：nums = [2]
 * 输出：0
 *
 * @author yixihan
 * @date 2022/11/21 0:40
 */
public class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort (nums);
        int n = nums.length;
        long ans = 0L;
        for (int i = 0; i < n; ++i)
            ans += (pow (2L, i) - pow (2L, n - 1 - i)) * nums[i]; // 在题目的数据范围下，这不会溢出
        return (int) (ans % MOD + MOD) % MOD; // 注意上面有减法，ans 可能为负数
    }

    private long pow(long x, int n) {
        long res = 1L;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }
}

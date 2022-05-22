package com.yixihan.binary_2.day14;

import java.util.Arrays;

/**
 * 给你一个数组 nums ，它包含 n 个正整数。
 * 你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。
 * <p>
 * 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
 * 输出：13
 * 解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。
 * 将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。
 * 下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
 * 输出：6
 * 解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。
 * 下标从 le = 3 到 ri = 4 的和为 3 + 3 = 6 。
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
 * 输出：50
 *
 * @author : yixihan
 * @create : 2022-05-22-9:15
 */
public class RangeSum {

    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] preSum = new int[n * (n + 1) / 2];
        int index = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                preSum[index++] = sum;
            }
        }

        Arrays.sort (preSum);

        for (int i = left - 1; i < right; i++) {
            ans = (ans + preSum[i]) % 1000000007;
        }

        return ans;
    }
}

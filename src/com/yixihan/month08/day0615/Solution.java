package com.yixihan.month08.day0615;

import java.util.Arrays;

/**
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * <p>
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * <p>
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 *
 * @author : yixihan
 * @create : 2022-06-15-6:49
 */
public class Solution {

    private int[] nums;
    private int n;

    public int smallestDistancePair(int[] nums, int k) {
        //排序
        Arrays.sort (nums);

        this.nums = nums;
        this.n = this.nums.length;

        // 二分查找的左右边界
        int left = 0;
        int right = this.nums[n - 1] - this.nums[0];

        // 二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = lessThanMidCount (mid);

            if (count >= k) {
                right = mid - 1;
                continue;
            }

            left = mid + 1;
        }

        return left;
    }

    /**
     * 小于mid的数对个数
     * 双指针算法
     *
     * @param mid 标定值
     * @return 数对个数
     */
    private int lessThanMidCount(int mid) {
        int count = 0;

        for (int i = 0, j = 0; j < n; j++) {
            while (nums[j] - nums[i] > mid) {
                i++;
            }
            count += j - i;
        }

        return count;
    }
}

package com.yixihan.month03.day0113;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 *
 * @author : yixihan
 * @create : 2022-01-13-6:42
 */
public class Solution {
    public int dominantIndex(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        Arrays.sort (nums);

        if (nums[nums.length - 1] > 0 && nums[nums.length - 2] > 0 && nums[nums.length - 1] / nums[nums.length - 2] >= 2) {
            return maxIndex;
        } else if (nums[nums.length - 1] > 0 && nums[nums.length - 2] == 0) {
            return maxIndex;
        } else {
            return -1;
        }
    }

    public int dominantIndex1(int[] nums) {

        int max = -1, second = -1, idx = -1;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                idx = i;
            } else if (nums[i] > second)
                second = nums[i];
        return max >= 2 * second ? idx : -1;
    }
}

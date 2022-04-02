package com.yixihan.offer.day04;

import java.util.Arrays;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * @author : yixihan
 * @create : 2022-02-24-14:02
 */
public class Search {
    public int search(int[] nums, int target) {

        int count = 0;
        int index = Arrays.binarySearch (nums, target);

        if (index < 0) {
            return count;
        } else {
            count++;
        }

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            } else {
                count++;
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            } else {
                count++;
            }
        }

        return count;
    }
}

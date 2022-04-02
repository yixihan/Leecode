package com.yixihan.offer.day13;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * @author : yixihan
 * @create : 2022-03-05-14:23
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 方法一 : 二分法
//        int[] ans = new int[2];
//
//        for (int num : nums) {
//            int val = target - num;
//
//            int index = Arrays.binarySearch (nums, val);
//
//            if (index >= 0) {
//                ans[0] = num;
//                ans[1] = nums[index];
//                break;
//            }
//        }
//
//        return ans;

        // 方法二 : 双指针
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[2];

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                ans[0] = nums[left];
                ans[1] = nums[right];
                break;
            } else if (sum > target){
                right--;
            } else if (sum < target) {
                left++;
            }
        }

        return ans;
    }
}

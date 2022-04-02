package com.yixihan.data_structure_2.day5;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，
 * 使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * <p>
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * <p>
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 *
 * @author : yixihan
 * @create : 2022-03-28-8:12
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (i < n - 2 && nums[i] < min) {
                min = nums[i];
            } else if (i < n - 1 && nums[i] > min && nums[i] < max) {
                max = nums[i];
            } else if (nums[i] > max) {
                return true;
            }
        }
        return false;

        // 更优解
//        int minValue = Integer.MAX_VALUE;
//        int maxValue = Integer.MAX_VALUE;
//
//        for (int num : nums) {
//            if (num <= minValue) {
//                minValue = num;
//            } else if (num <= maxValue) {
//                maxValue = num;
//            } else {
//                return true;
//            }
//        }
//
//        return false;
    }
}

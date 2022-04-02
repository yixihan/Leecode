package com.yixihan.data_structure_2.day5;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * @author : yixihan
 * @create : 2022-03-28-8:14
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        // 方法一 : 简单易懂版
        //        int n = nums.length;
        //        int[] left = new int[n];
        //        int[] right = new int[n];
        //        int[] ans = new int[n];
        //        Arrays.fill (left, 1);
        //        Arrays.fill (right, 1);
        //
        //        for (int i = 1; i < n; i++) {
        //            left[i] = nums[i - 1] * left[i - 1];
        //        }
        //
        //        for (int i = n - 2; i >= 0; i--) {
        //            right[i] = nums[i + 1] * right[i + 1];
        //        }
        //
        //        for (int i = 0; i < n; i++) {
        //            ans[i] = left[i] * right[i];
        //        }
        //
        //        // System.out.println (Arrays.toString (left));
        //        // System.out.println (Arrays.toString (right));
        //
        //
        //        return ans;

        // 高效方法
        int n = nums.length;
        int[] ans = new int[n];
        int left = 1;
        int right = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            ans[i] *= left;
            left *= nums[i];

            ans[n - 1 - i] *= right;
            right *= nums[n - 1 - i];
        }
        return ans;
    }
}

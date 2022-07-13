package com.yixihan.random.day0713;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-07-13-9:33
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort (nums);
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs (target - sum) < Math.abs (target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }

        return ans;
    }
}
// -4 -1 1 2
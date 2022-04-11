package com.yixihan.binary_1.day5;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author : yixihan
 * @create : 2022-04-01-14:00
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {

        boolean flag = false;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return new int[]{-1, -1};
        }

        int[] ans = new int[]{mid, mid};

        while (ans[0] - 1 >= 0 && nums[ans[0] - 1] == target) {
            ans[0]--;
        }

        while (ans[1] + 1 < n && nums[ans[1] + 1] == target) {
            ans[1]++;
        }

        return ans;
    }
}

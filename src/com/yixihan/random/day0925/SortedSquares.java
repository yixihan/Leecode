package com.yixihan.random.day0925;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @author : yixihan
 * @date : 2022-09-25-11:02
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int index = 0;
        int l;
        int r;
        int min = Math.abs (nums[0]);
        int minIdx = 0;

        for (int i = 1; i < len; i++) {
            if (min > Math.abs (nums[i])) {
                min = Math.abs (nums[i]);
                minIdx = i;
            }
        }
        l = minIdx;
        r = minIdx + 1;
        while (l >= 0 || r < len) {
            min = Integer.MAX_VALUE;
            if (l >= 0) {
                min = Math.min (nums[l] * nums[l], min);
            }
            if (r < len) {
                min = Math.min (nums[r] * nums[r], min);
            }
            if (l >= 0 && min == nums[l] * nums[l]) {
                l--;
            } else if (r < len && min == nums[r] * nums[r]) {
                r++;
            } else {
                break;
            }
            ans[index++] = min;
        }

        return ans;
    }
}

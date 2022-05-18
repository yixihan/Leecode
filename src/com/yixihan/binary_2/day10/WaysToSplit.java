package com.yixihan.binary_2.day10;

/**
 * 我们称一个分割整数数组的方案是 好的 ，当它满足：
 * <p>
 * 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
 * left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
 * 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：1
 * 解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
 * <p>
 * 输入：nums = [1,2,2,2,5,0]
 * 输出：3
 * 解释：nums 总共有 3 种好的分割方案：
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：没有好的分割方案。
 *
 * @author : yixihan
 * @create : 2022-05-18-13:20
 */
public class WaysToSplit {

    public int waysToSplit(int[] nums) {
        int len = nums.length;
        int ans = 0;

        for (int i = 1; i < len; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < len; i++) {
            int left1 = i + 1;
            int right1 = len - 2;

            while (left1 <= right1) {
                int mid = (left1 + right1) >> 1;
                if (nums[i] <= nums[mid] - nums[i]) {
                    right1 = mid - 1;
                } else {
                    left1 = mid + 1;
                }
            }

            int left2 = left1;
            int right2 = len - 2;

            while (left2 <= right2) {
                int mid2 = (left2 + right2) >> 1;
                if (nums[mid2] - nums[i] <= nums[len - 1] - nums[mid2]) {
                    left2 = mid2 + 1;
                } else {
                    right2 = mid2 - 1;
                }
            }

            ans += Math.max (right2 - left1 + 1, 0);
            ans %= 1000000007;
        }

        return ans;
    }
}

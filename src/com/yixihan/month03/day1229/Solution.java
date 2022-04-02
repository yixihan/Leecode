package com.yixihan.month03.day1229;

/**
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 *
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 *
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 *
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 *
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 *
 * @author : yixihan
 * @create : 2021-12-29-14:48
 */
public class Solution {

    /**
     * 由于 nums[d] - nums[c]nums[d]−nums[c] 可能为负，故利用 1 <= nums[i] <= 1001 <= nums[i] <= 100 做一个值偏移。
     *
     */
    public int countQuadruplets(int[] nums) {

        int n = nums.length;
        int result = 0;
        int[] cnt = new int[10010];

        for (int i = n - 3; i >= 1; i--) {
            for (int j = i + 2; j < n; j++) {
                cnt[nums[j] - nums[i + 1] + 200]++;
            }

            for (int k = 0; k < i; k++) {
                result += cnt[nums[k] + nums[i] + 200];
            }
        }

        return result;
    }
}

package com.yixihan.greedy;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，
 * 第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 *
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 *
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 *
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-03-19-14:00
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int flag = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (flag == 0) {
                    flag = nums[i] - nums[i - 1] > 0 ? 1 : -1;
                    dp[i] = dp[i - 1] + 1;
                } else if (flag == 1) {
                    dp[i] = nums[i] - nums[i - 1] < 0 ? dp[i - 1] + 1 : dp[i - 1];
                    flag = nums[i] - nums[i - 1] < 0 ? -1 : 1;
                } else {
                    dp[i] = nums[i] - nums[i - 1] > 0 ? dp[i - 1] + 1 : dp[i - 1];
                    flag = nums[i] - nums[i - 1] < 0 ? -1 : 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n - 1];

        // 另一种思路
//        int n = nums.length;
//        if (n < 2) {
//            return n;
//        }
//        int up = 1;
//        int down = 1;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                up = down + 1;
//            }
//            if (nums[i] < nums[i - 1]) {
//                down = up + 1;
//            }
//        }
//        return Math.max(up, down);
    }
}

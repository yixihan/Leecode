package com.yixihan.binary_2.day5;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-04-15-10:19
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            System.out.println ("fast : " + fast);
            System.out.println ("slow : " + slow);

            if (slow == fast) {
                fast = 0;

                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }

                return nums[slow];
            }
        }
    }
}

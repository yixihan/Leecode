package com.yixihan.month02.day1203;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和
 *
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 *
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 *
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *
 * @author : yixihan
 * @create : 2021-12-03-12:58
 */
public class Solution {

    /**
     * 重复这个过程恰好 k 次。可以多次选择同一个下标 i
     * 暴力解法
     */
    public int largestSumAfterKNegations(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            Arrays.sort (nums);
            nums[0] = - nums[0];
        }

        System.out.println (Arrays.toString (nums));

        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    /**
     * 贪心算法
     */
    public int largestSumAfterKNegations1(int[] nums, int k) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of (nums)
                .boxed ()
                .sorted ((o1, o2) -> Math.abs (o2) - Math.abs (o1))
                .mapToInt (Integer::intValue).toArray ();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream (nums).sum ();
    }
}

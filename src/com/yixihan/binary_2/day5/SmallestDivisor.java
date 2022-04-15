package com.yixihan.binary_2.day5;

/**
 * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 * <p>
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 * <p>
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 * <p>
 * 题目保证一定有解。
 * <p>
 * 输入：nums = [1,2,5,9], threshold = 6
 * 输出：5
 * 解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
 * 如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
 * <p>
 * 输入：nums = [2,3,5,7,11], threshold = 11
 * 输出：3
 * <p>
 * 输入：nums = [19], threshold = 5
 * 输出：4
 *
 * @author : yixihan
 * @create : 2022-04-15-10:40
 */
public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max (num, right);
        }

        while (left < right) {
            int mid = (left + right) >> 1;
            int sum = 0;
            // System.out.println (mid);
            for (int num : nums) {
                sum += num % mid == 0 ? num / mid : num / mid + 1;
                // System.out.println (sum);
            }
            // System.out.println ();

            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

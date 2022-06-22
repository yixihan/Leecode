package com.yixihan.random.day0622;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 * 请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
 * <p>
 * 返回追加到 nums 中的 k 个整数之和。
 * <p>
 * 输入：nums = [1,4,25,10,25], k = 2
 * 输出：5
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
 * nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。
 * <p>
 * 输入：nums = [5,6], k = 6
 * 输出：25
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 1 、2 、3 、4 、7 和 8 。
 * nums 最终元素和为 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 1 + 2 + 3 + 4 + 7 + 8 = 25 ，所以返回 25 。
 *
 * @author : yixihan
 * @create : 2022-06-22-8:36
 */
public class MinimalKSum {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort (nums);
        Set<Integer> set = new HashSet<> ();
        long sum = 0;

        for (int num : nums) {
            if (!set.contains (num) && num <= k) {
                k++;
                sum += num;
            }
            set.add (num);
        }

        return (long) (1 + k) * k / 2 - sum;
    }
}

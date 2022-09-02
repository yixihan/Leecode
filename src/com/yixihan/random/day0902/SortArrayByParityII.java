package com.yixihan.random.day0902;

/**
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * <p>
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * <p>
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * <p>
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 输入：nums = [2,3]
 * 输出：[2,3]
 *
 * @author : yixihan
 * @create : 2022-09-02-12:58
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 1;
        int evenIndex = 0;
        int len = nums.length;
        int[] ans = new int[len];

        for (int num : nums) {
            if (num % 2 == 0) {
                ans[evenIndex] = num;
                evenIndex += 2;
            } else {
                ans[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return ans;
    }
}

package com.yixihan.month14.day1124;

/**
 * 给你一个整数数组 nums 和两个整数：left 及 right 。
 * 找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 * <p>
 * 输入：nums = [2,1,4,3], left = 2, right = 3
 * 输出：3
 * 解释：满足条件的三个子数组：[2], [2, 1], [3]
 * <p>
 * 输入：nums = [2,9,2,5,6], left = 2, right = 8
 * 输出：7
 *
 * @author yixihan
 * @date 2022/11/24 9:06
 */
public class Solution {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
        return numSubarrayBoundedMax (A, R) - numSubarrayBoundedMax (A, L - 1);
    }

    private int numSubarrayBoundedMax(int[] A, int Max) {
        int res = 0;
        int numSubArray = 0;
        for (int num : A) {
            if (num <= Max) {
                numSubArray++;
                res += numSubArray;
            } else {
                numSubArray = 0;
            }
        } return res;
    }
}

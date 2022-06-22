package com.yixihan.random.day0622;

/**
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，
 * 所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * <p>
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 * <p>
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 *
 * @author : yixihan
 * @create : 2022-06-22-8:32
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;
        int r = n - 1;
        while (true) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{l, r};
    }
}

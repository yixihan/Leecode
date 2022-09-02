package com.yixihan.random.day0902;

/**
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，
 * 请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
 * <p>
 * 返回 abs(i - start) 。
 * <p>
 * 题目数据保证 target 存在于 nums 中。
 * <p>
 * 输入：nums = [1,2,3,4,5], target = 5, start = 3
 * 输出：1
 * 解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案是 abs(4 - 3) = 1 。
 * <p>
 * 输入：nums = [1], target = 1, start = 0
 * 输出：0
 * 解释：nums[0] = 1 是唯一一个等于 target 的值，所以答案是 abs(0 - 0) = 0 。
 *
 * @author : yixihan
 * @create : 2022-09-02-13:01
 */
public class GetMinDistance {

    public int getMinDistance(int[] nums, int target, int start) {
        int indexL = start;
        int indexR = start;

        while (indexL >= 0) {
            if (nums[indexL] != target) {
                indexL--;
            } else {
                break;
            }
        }

        while (indexR < nums.length) {
            if (nums[indexR] != target) {
                indexR++;
            } else {
                break;
            }
        }

        int minL = indexL >= 0 && nums[indexL] == target ? Math.abs (start - indexL) : nums.length + 1;
        int minR = indexR < nums.length && nums[indexR] == target ? Math.abs (start - indexR) : nums.length + 1;

        return Math.min (minL, minR);
    }
}

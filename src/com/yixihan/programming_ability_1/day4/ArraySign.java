package com.yixihan.programming_ability_1.day4;

/**
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 *
 * 返回 signFunc(product) 。
 *
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 *
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 *
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 *
 * @author : yixihan
 * @create : 2022-03-14-11:24
 */
public class ArraySign {
    public int arraySign(int[] nums) {
        double product = 1;

        for (int num : nums) {
            product *= num;
        }
        System.out.println (product);

        return signFunc (product);

    }

    private int signFunc (double x) {
        if (x < 0) {
            return -1;
        } else if (x > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

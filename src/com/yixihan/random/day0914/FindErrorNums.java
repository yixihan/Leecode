package com.yixihan.random.day0914;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 * @author : yixihan
 * @create : 2022-09-14-10:48
 */
public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len];
        int val1 = 0;

        for (int num : nums) {
            tmp[num - 1]++;
            if (tmp[num - 1] == 2) {
                val1 = num;
            }
        }

        for (int i = 0; i < len; i++) {
            if (tmp[i] == 0) {
                return new int[]{val1, i + 1};
            }
        }

        return new int[]{};
    }
}

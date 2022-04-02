package com.yixihan.month01.day1020;

import org.junit.jupiter.api.Test;

/**
 *
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 * @author yixihan
 */
public class MinimumMoves {

    public int minMoves(int[] nums) {

        if (compare(nums)) {
            return 0;
        }

        return getDifference(nums);

    }

    public boolean compare (int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public int getMin (int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }

    public int getDifference (int[] nums) {

        int min = getMin(nums);
        int count = 0;

        for (int num : nums) {
            count += num - min;
        }

        return count;
    }


    @Test
    public void test () {
        System.out.println(minMoves(new int[]{1, 2, 3,4,5,6,7,8,9}));
    }
}



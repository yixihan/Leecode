package com.yixihan.offer.day16;

import java.util.Arrays;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * @author : yixihan
 * @create : 2022-03-08-15:29
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort (nums);
        int count = 4;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (nums[i + 1] == nums[i] && nums[i] != 0) {
                return false;
            }

            count -= nums[i + 1] - nums[i];

        }

        return count >= 0;

    }
}

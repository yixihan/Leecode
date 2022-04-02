package com.yixihan.data_structure_2.day1;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 * 输入：[3,2,3]
 * 输出：3
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-03-24-10:00
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {

        // 方法一 : 找规律, 此数必定在数组中间
//        Arrays.sort (nums);
//
//        return nums[nums.length / 2];

        // 方法二 : 摩尔投票法
        int count = 1;
        int mor = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == mor) {
                count++;
            } else {
                count--;

                if (count == 0) {
                    mor = nums[i + 1];

                }
            }
        }

        return mor;
    }
}

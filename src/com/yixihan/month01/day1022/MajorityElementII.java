package com.yixihan.month01.day1022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 输入：[3,2,3]
 * 输出：[3]
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * @author : yixihan
 * @create : 2021-10-22-22:26
 */
public class MajorityElementII {


    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length / 3;
        int count = 0;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                if (count >= n) {
                    list.add(nums[i - 1]);
                }
                count = 0;
            }
        }

        if (count >= n) {
            list.add(nums[nums.length - 1]);
        }

        return list;
    }

    @Test
    public void test () {

        int[] ints = {3,2,3,4,5,5,5,4,4,6,5,6,6};

        List<Integer> list = majorityElement(ints);

        System.out.println(list.toString());
    }
}

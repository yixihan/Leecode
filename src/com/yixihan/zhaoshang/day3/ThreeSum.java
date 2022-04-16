package com.yixihan.zhaoshang.day3;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-04-16-14:38
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<> ();
        }

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort (nums);

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return new ArrayList<> (set);
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;

            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    set.add (Arrays.asList (nums[i], nums[left], nums[right]));
                }
            }
        }

        return new ArrayList<> (set);
    }
}

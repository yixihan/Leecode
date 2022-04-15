package com.yixihan.zhaoshang.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author : yixihan
 * @create : 2022-04-15-10:42
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<> (nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey (nums[i])) {
                return new int[]{map.get (nums[i]), i};
            }
            map.put (target - nums[i], i);
        }

        return new int[]{};
    }
}

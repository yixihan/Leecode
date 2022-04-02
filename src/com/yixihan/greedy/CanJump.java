package com.yixihan.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * @author : yixihan
 * @create : 2022-03-13-10:59
 */
public class CanJump {

    Map<Integer, List<Integer>> map = new HashMap<> ();

    public boolean canJump(int[] nums) {
        return watch (nums, 0, nums[0]) != -1;
    }

    private int watch (int[] nums, int startIndex, int jumpStep) {

        if (map.containsKey (startIndex)) {
            return startIndex;
        }

        if (startIndex + jumpStep >= nums.length - 1) {
            return startIndex;
        }

        List<Integer> nextSteps = new ArrayList<> ();

        for (int i = startIndex + 1; i <= startIndex + jumpStep; i++) {
            if (nums[i] + i >= nums.length - 1) {
                return i;
            }
            if (nums[i] != 0) {
                nextSteps.add (i);
            }
        }
        System.out.println (nextSteps);
        map.put (startIndex, nextSteps);

        for (int nextStep : nextSteps) {
            int index = watch (nums, nextStep, nums[nextStep]);
            if (index > 0) {
                return index;
            }
        }

        return -1;
    }
}

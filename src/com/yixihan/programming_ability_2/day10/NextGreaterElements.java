package com.yixihan.programming_ability_2.day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
 * 返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 *
 * @author : yixihan
 * @create : 2022-04-01-14:34
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<> ();
        int n = nums.length;
        int[] ans = new int[n];
//        Arrays.fill (ans, -1);
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (! stack.isEmpty () && num > nums[stack.peek ()]) {
                ans[stack.pop ()] = num;
            }

            if (i < n) {
                stack.add (i);
            }
        }

        return ans;
    }
}

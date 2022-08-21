package com.yixihan.random.day0821;

import java.util.Stack;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *
 * @author : yixihan
 * @create : 2022-08-21-8:59
 */
public class MaxWidthRamp {

    public int maxWidthRamp(int[] nums) {
        //        int index = nums.length - 1;
        //
        //        while (index > 0) {
        //            int left = 0;
        //            int right = index;
        //
        //            while (right < nums.length) {
        //                if (nums[left] <= nums[right]) {
        //                    return right - left;
        //                } else {
        //                    left++;
        //                    right++;
        //                }
        //            }
        //
        //            index--;
        //        }
        //
        //        return 0;

        int ans = 0;
        Stack<Integer> stack = new Stack<> ();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty () || nums[i] < nums[stack.peek ()]) {
                stack.add (i);
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty () && nums[i] >= nums[stack.peek ()]) {
                ans = Math.max (ans, i - stack.pop ());
            }
        }

        return ans;
    }
}

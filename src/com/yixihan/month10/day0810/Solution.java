package com.yixihan.month10.day0810;

import java.util.Arrays;
import java.util.Stack;

/**
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 如果方程中只有一个解，要保证返回值 'x' 是一个整数。
 * <p>
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * <p>
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * <p>
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 *
 * @author : yixihan
 * @create : 2022-08-10-9:20
 */
public class Solution {

    public String solveEquation(String equation) {
        String[] splits = equation.split ("=");

        int[] left = helper (splits[0]);
        int[] right = helper (splits[1]);
        int[] all = new int[]{left[0] - right[0], left[1] - right[1]};

        System.out.println (Arrays.toString (left));
        System.out.println (Arrays.toString (right));
        System.out.println (Arrays.toString (all));

        if (all[0] == 0) {
            if (all[1] != 0) {
                return "No solution";
            } else {
                return "Infinite solutions";
            }
        } else if (all[1] % all[0] != 0) {
            return "No solution";
        } else {
            return "x=" + -(all[1]) / all[0];
        }
    }

    private int[] helper(String str) {
        Stack<Character> stack = new Stack<> ();
        int[] nums = new int[2];

        for (char c : str.toCharArray ()) {
            if ((c == '+' || c == '-') && !stack.isEmpty ()) {
                extracted (stack, nums);
            }
            stack.push (c);
        }
        extracted (stack, nums);
        return nums;
    }

    private void extracted(Stack<Character> stack, int[] nums) {
        StringBuilder sb = new StringBuilder ();
        while (!stack.isEmpty ()) {
            sb.append (stack.pop ());
        }
        sb.reverse ();
        // System.out.println (sb);
        boolean flag = sb.charAt (0) == '+' || sb.charAt (0) == '-';
        char x = flag ? sb.charAt (0) : '+';
        if (sb.toString ().contains ("x")) {
            if (!flag) {
                nums[0] += sb.length () > 1 ? Integer.parseInt (sb.substring (0, sb.length () - 1)) : 1;
            } else if (x == '+') {
                nums[0] += sb.length () > 2 ? Integer.parseInt (sb.substring (1, sb.length () - 1)) : 1;
            } else {
                nums[0] -= sb.length () > 2 ? Integer.parseInt (sb.substring (1, sb.length () - 1)) : 1;
            }
        } else {
            if (!flag) {
                nums[1] += Integer.parseInt (sb.substring (0));
            } else if (x == '+') {
                nums[1] += Integer.parseInt (sb.substring (1));
            } else {
                nums[1] -= Integer.parseInt (sb.substring (1));
            }
        }
    }
}

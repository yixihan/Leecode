package com.yixihan.greedy;

import java.util.Stack;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
 * <p>
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *
 * @author : yixihan
 * @create : 2022-03-20-13:51
 */
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {

        if (k >= num.length () || num.length () == 0) {
            return "0";
        }

        char[] arr = num.toCharArray ();
        Stack<Integer> stack = new Stack<> ();

        for (char c : arr) {
            int val = c - '0';
            while (!stack.isEmpty () && val < stack.peek () && k > 0) {
                stack.pop ();
                k--;
            }

            if (val != 0 || !stack.isEmpty ()) {
                stack.push (val);
            }
        }

        while (k-- > 0 && !stack.isEmpty ()) {
            stack.pop ();
        }

        if (stack.isEmpty ()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder (stack.size ());
        while (!stack.isEmpty ()) {
            sb.append (stack.pop ());
        }

        return sb.reverse ().toString ();
    }
}

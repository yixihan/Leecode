package com.yixihan.month12.day1009;

import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * 输入： "()"
 * 输出： 1
 * <p>
 * 输入： "(())"
 * 输出： 2
 * <p>
 * 输入： "()()"
 * 输出： 2
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 *
 * @author yixihan
 * @date 2022-10-09-9:04
 */
public class Solution {

    /**
     * 给定一个标记n，若‘（’则n左移，若‘）’则n右移，若遇到()则sum+=n
     * @param s
     * @return
     */
    public int scoreOfParentheses(String s) {
        int ans = 0;
        int n = 0;
        boolean flag = false;
        for (char c : s.toCharArray ()) {
            if (c == '(') {
                n = n == 0 ? 1 : n << 1;
                flag = true;
            } else if (c == ')') {
                if (flag) {
                    ans += n;
                    n = 1;
                } else {
                    n >>= 1;
                    flag = false;
                }
            }
        }

        return ans;
    }
}

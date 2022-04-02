package com.yixihan.data_structure_1.day9;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author : yixihan
 * @create : 2022-03-18-14:15
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<> ();

        for (char c : s.toCharArray ()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push (c);
                continue;
            }
            if (stack.size () > 0) {
                if (c == ')' && stack.peek () == '(') {
                    stack.pop ();
                } else if (c == ']' && stack.peek () == '[') {
                    stack.pop ();
                } else if (c == '}' && stack.peek () == '{') {
                    stack.pop ();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.size () == 0;
    }
}

package com.yixihan.random.day0623;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 解释：先反转子字符串 "love" ，然后反转整个字符串。
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * @author : yixihan
 * @create : 2022-06-23-9:07
 */
public class ReverseParentheses {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<> ();
        StringBuilder sb = new StringBuilder ();

        for (char c : s.toCharArray ()) {
            if (c != ')') {
                stack.push (c);
            } else {
                StringBuilder tmp = new StringBuilder ();
                while (stack.peek () != '(') {
                    tmp.append (stack.pop ());
                }
                stack.pop ();
                for (int i = 0; i < tmp.length (); i++) {
                    stack.push (tmp.charAt (i));
                }
            }
        }
        while (!stack.isEmpty ()) {
            sb.append (stack.pop ());
        }

        return sb.reverse ().toString ();
    }
}

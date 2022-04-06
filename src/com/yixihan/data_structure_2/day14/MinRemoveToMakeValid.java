package com.yixihan.data_structure_2.day14;

import java.util.Stack;

/**
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * <p>
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * <p>
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * <p>
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 *
 * @author : yixihan
 * @create : 2022-04-06-13:29
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<> ();
        char[] arr = s.toCharArray ();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder (n);

        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                stack.push (i);
                visited[i] = true;
            } else if (arr[i] == ')') {
                if (stack.isEmpty ()) {
                    visited[i] = true;
                } else {
                    visited[stack.pop ()] = false;
                    ;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sb.append (arr[i]);
            }
        }

        return sb.toString ();
    }
}

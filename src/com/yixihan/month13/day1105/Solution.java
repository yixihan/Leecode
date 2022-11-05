package com.yixihan.month13.day1105;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *
 * @author yixihan
 * @date 2022/11/5 22:23
 */
public class Solution {

    public boolean parseBoolExpr(String expression) {
        Deque<Character> stk = new ArrayDeque<> ();

        for (char c : expression.toCharArray ()) {
            if (c != '(' && c != ')' && c != ',') {
                stk.push (c);
            } else if (c == ')') {
                int t = 0, f = 0;
                while (stk.peek () == 't' || stk.peek () == 'f') {
                    t += stk.peek () == 't' ? 1 : 0;
                    f += stk.peek () == 'f' ? 1 : 0;
                    stk.pop ();
                }
                char op = stk.pop ();
                c = 'f';
                if ((op == '!' && f > 0) || (op == '&' && f == 0) || (op == '|' && t > 0)) {
                    c = 't';
                }
                stk.push (c);
            }
        }
        return stk.peek () == 't';
    }
}

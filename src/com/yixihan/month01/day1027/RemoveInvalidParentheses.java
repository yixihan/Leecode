package com.yixihan.month01.day1027;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 *
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 *
 *
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 *
 *
 * 输入：s = ")("
 * 输出：[""]
 *
 * @author : yixihan
 * @create : 2021-10-27-23:31
 */
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        int lr = 0, rr = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lr++;
            } else if (c == ')') {
                if (lr == 0) {
                    rr++;
                } else {
                    lr--;
                }
            }
        }

        List<String> result = new LinkedList<>();
        dfs(result, s, 0, 0, 0, lr, rr);
        return result;
    }

    private void dfs(List<String> result, String str, int start, int lc, int rc, int lr, int rr) {
        if (lr == 0 && rr == 0) {
            if (valid(str)) {
                result.add(str);
            }
            return;
        }

        char[] cs = str.toCharArray();
        for (int i = start; i < cs.length; i++) {
            if (cs[i] != '(' && cs[i] != ')') {
                continue;
            }

            if (cs.length - i < lr + rr) {
                return;
            }

            boolean left = cs[i] == '(';
            if (i == start || cs[i] != cs[i - 1]) {
                String s = new String(cs, 0, i) + new String(cs, i + 1, cs.length - i - 1);
                if (lr > 0 && left) {
                    dfs(result, s, i, lc, rc, lr - 1, rr);
                }

                if (rr > 0 && !left) {
                    dfs(result, s, i, lc, rc, lr, rr - 1);
                }
            }

            lc = left ? lc + 1 : lc;
            rc = left ? rc : rc + 1;
            if (rc > lc) {
                return;
            }
        }
    }

    private boolean valid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}

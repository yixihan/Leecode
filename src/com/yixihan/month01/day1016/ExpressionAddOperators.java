package com.yixihan.month01.day1016;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 备注 : 做不来
 * @author yixihan
 */
public class ExpressionAddOperators {


    int n;
    String num;
    int target;
    List<String> ans;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.next();

        int target = sc.nextInt();

        ExpressionAddOperators test = new ExpressionAddOperators();

        List<String> arr = test.addOperators(num, target);

        System.out.println(arr.toString());

    }


    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        backtrack(expr, 0, 0, 0);
        return ans;
    }

    public void backtrack(StringBuffer expr, int i, long res, long mul) {
        if (i == n) {
            if (res == target) {
                ans.add(expr.toString());
            }
            return;
        }
        int signIndex = expr.length();
        if (i > 0) {
            // 占位，下面填充符号
            expr.append(0);
        }
        long val = 0;
        // 枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
        for (int j = i; j < n && (j == i || num.charAt(i) != '0'); ++j) {
            val = val * 10 + num.charAt(j) - '0';
            expr.append(num.charAt(j));
            // 表达式开头不能添加符号
            if (i == 0) {
                backtrack(expr, j + 1, val, val);
                // 枚举符号
            } else {
                expr.setCharAt(signIndex, '+');
                backtrack(expr, j + 1, res + val, val);

                expr.setCharAt(signIndex, '-');
                backtrack(expr, j + 1, res - val, -val);

                expr.setCharAt(signIndex, '*');
                backtrack(expr, j + 1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(signIndex);
    }
}

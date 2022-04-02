package com.yixihan.programming_ability_2.day3;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意 两个整数之间的除法只保留整数部分。
 * <p>
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 提示：
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * <p>
 * 逆波兰表达式：
 * <p>
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 *
 * @author : yixihan
 * @create : 2022-03-25-14:11
 */
public class evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<> ();

        for (String token : tokens) {
            if (!"+".equals (token) && !"-".equals (token) && !"*".equals (token) && !"/".equals (token)) {
                stack.push (Integer.parseInt (token));
            } else {
                int val1 = stack.pop ();
                int val2 = stack.pop ();
                // System.out.println (val1);
                // System.out.println (val2);
                int val = -1;

                switch (token) {
                    case "+":
                        val = val2 + val1;
                        // System.out.println ("+, val : " + val);
                        break;
                    case "-":
                        val = val2 - val1;
                        // System.out.println ("-, val : " + val);
                        break;
                    case "*":
                        val = val2 * val1;
                        // System.out.println ("*, val : " + val);
                        break;
                    case "/":
                        val = val2 / val1;
                        // System.out.println ("/, val : " + val);
                        break;
                    default:
                        break;
                }

                stack.push (val);
                // System.out.println (stack);
            }
        }

        return stack.pop ();
    }
}

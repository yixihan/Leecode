package com.yixihan.month09.day0701;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。
 * 你可以 按任意顺序 返回答案。
 * <p>
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * <p>
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * <p>
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * @author : yixihan
 * @create : 2022-07-01-8:58
 */
public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        if (input.length () == 0) {
            return new ArrayList<> ();
        }
        List<Integer> result = new ArrayList<> ();
        int num = 0;
        //考虑是全数字的情况
        int index = 0;
        while (index < input.length () && !isOperation (input.charAt (index))) {
            num = num * 10 + input.charAt (index) - '0';
            index++;
        }
        //将全数字的情况直接返回
        if (index == input.length ()) {
            result.add (num);
            return result;
        }

        for (int i = 0; i < input.length (); i++) {
            //通过运算符将字符串分成两部分
            if (isOperation (input.charAt (i))) {
                List<Integer> result1 = diffWaysToCompute (input.substring (0, i));
                List<Integer> result2 = diffWaysToCompute (input.substring (i + 1));
                //将两个结果依次运算
                for (int j = 0; j < result1.size (); j++) {
                    for (int k = 0; k < result2.size (); k++) {
                        char op = input.charAt (i);
                        result.add (caculate (result1.get (j), op, result2.get (k)));
                    }
                }
            }
        }
        return result;
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}

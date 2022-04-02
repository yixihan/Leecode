package com.yixihan.offer.day22;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * @author : yixihan
 * @create : 2022-03-13-10:18
 */
public class Add {
    public int add(int a, int b) {
        if (a == 0 || b == 0) {
            return a ^ b;
        }
        return add(a ^ b, (a & b) << 1);
    }
}

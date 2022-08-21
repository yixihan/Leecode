package com.yixihan.random.day0821;

/**
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * @author : yixihan
 * @create : 2022-08-21-9:30
 */
public class Add {

    public int add(int a, int b) {
        if (a == 0) {
            return b;
        }

        return add ((a & b) << 1, a ^ b);
    }
}

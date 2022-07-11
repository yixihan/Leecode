package com.yixihan.random.day0711;

import java.util.ArrayList;
import java.util.List;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * <p>
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 *
 * @author : yixihan
 * @create : 2022-07-11-8:33
 */
public class IsUgly {

    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}

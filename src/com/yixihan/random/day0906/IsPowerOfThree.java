package com.yixihan.random.day0906;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * 输入：n = 27
 * 输出：true
 *
 * 输入：n = 0
 * 输出：false
 *
 * 输入：n = 9
 * 输出：true
 *
 * 输入：n = 45
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-09-06-13:17
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }

        return n == 1;
    }
}

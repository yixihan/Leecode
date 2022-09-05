package com.yixihan.random.day0905;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * <p>
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * <p>
 * 输入：n = 3
 * 输出：false
 * <p>
 * 输入：n = 4
 * 输出：true
 * <p>
 * 输入：n = 5
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-09-05-14:03
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        for (; n > 1; n /= 2) {
            if (n % 2 != 0) {
                return false;
            }
        }

        return n == 1;
    }
}

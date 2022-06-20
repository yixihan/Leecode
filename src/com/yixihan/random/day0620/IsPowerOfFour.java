package com.yixihan.random.day0620;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 输入：n = 16
 * 输出：true
 * <p>
 * 输入：n = 5
 * 输出：false
 * <p>
 * 输入：n = 1
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-06-20-15:18
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int n) {
        //        if (n < 1) {
        //            return false;
        //        }
        //        if (n == 1) {
        //            return true;
        //        }
        //        if (n % 4 != 0) {
        //            return false;
        //        } else {
        //            return isPowerOfFour (n / 4);
        //        }

        if (n <= 0) return false;
        int x = (int) Math.sqrt (n);
        return x * x == n && (x & -x) == x;

    }
}

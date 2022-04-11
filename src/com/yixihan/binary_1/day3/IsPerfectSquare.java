package com.yixihan.binary_1.day3;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * 输入：num = 14
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-03-30-8:13
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {

        // 方法一 : 二分
        long left = 0;
        long right = num;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;

        // 方法二 : 阶乘
//        for (int i = 1; num > 0; i += 2) {
//            num -= i;
//        }
//        return num == 0;
    }
}

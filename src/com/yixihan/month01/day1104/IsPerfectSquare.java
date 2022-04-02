package com.yixihan.month01.day1104;

import org.junit.jupiter.api.Test;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 *
 * 输入：num = 16
 * 输出：true
 *
 * 输入：num = 14
 * 输出：false
 * @author : yixihan
 * @create : 2021-11-04-22:13
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare (int num) {
        int i = (int) Math.sqrt(num);

        return i * i == num;
    }

    /**
     * 二分法
     */
    public boolean isPerfectSquare1 (int num) {

        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int t = num / mid;

            if (t == mid) {
                if (num % mid == 0) {
                    return true;
                }
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }


    /**
     * 阶乘法
     * 1 + 3 + 5 + ... + (2 * n - 1) = (2 * n - 1 + 1) * n = n * n
     */
    public boolean isPerfectSquare3 (int num) {

        for (int i = 1;num > 0;i += 2) {
            num -= i;
        }
        return num == 0;
    }

    @Test
    public void test () {
        System.out.println(isPerfectSquare1(2147483647));
    }
}

package com.yixihan.month02.day1205;

/**
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 输入：a = 2, b = [3]
 * 输出：8
 *
 * 输入：a = 2, b = [1,0]
 * 输出：1024
 *
 * 输入：a = 1, b = [4,3,3,8,5,2]
 * 输出：1
 *
 * 输入：a = 2147483647, b = [2,0,0]
 * 输出：1198
 *
 * @author : yixihan
 * @create : 2021-12-05-17:47
 */
public class SuperPow {

    public int superPow(int a, int[] b) {
        int val = a % 1337;

        if (val == 1) {
            return 1;
        }

        int length = b.length;
        int mod = mod(val, b[length - 1]);

        for (int i = length - 2; i >= 0; i--) {
            val = mod (val, 10);
            mod *= mod (val, b[i]);
            mod %= 1337;
        }

        return mod;

    }

    private int mod (int val, int x) {
        int i = 1;

        while (x-- > 0) {
            i *= val;
            i %= 1337;
        }

        return i;

    }
}

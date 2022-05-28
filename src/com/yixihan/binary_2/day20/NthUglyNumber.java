package com.yixihan.binary_2.day20;

/**
 * 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
 * <p>
 * 丑数是可以被 a 或 b 或 c 整除的 正整数 。
 * <p>
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 * <p>
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 * <p>
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * <p>
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 * @author : yixihan
 * @create : 2022-05-28-14:24
 */
public class NthUglyNumber {

    long ab, ac, bc;
    long abc;
    long a, b, c;

    public int nthUglyNumber(int n, int a, int b, int c) {
        ab = lcm (a, b);
        ac = lcm (a, c);
        bc = lcm (b, c);
        abc = lcm (ab, c);
        this.a = a;
        this.b = b;
        this.c = c;
        int left = Math.min (a, Math.min (b, c));
        int right = (int) 2e9;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (minor (mid, n)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    private boolean minor(int mid, int cmp) {
        return mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc < cmp;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd (b, a % b);
    }

    private long lcm(long a, long b) {
        return a * b / gcd (a, b);
    }
}

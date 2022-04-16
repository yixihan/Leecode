package com.yixihan.month07.day0416;

/**
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 * <p>
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * <p>
 * 输入： n = 1
 * 输出： 9
 *
 * @author : yixihan
 * @create : 2022-04-16-14:25
 */
public class Solution {

    static int[] ans = {9, 987, 123, 597, 677, 1218, 877, 475};

    public int largestPalindrome(int n) {
        // 打表
        //        return ans[n - 1];

        int ans = 0;
        if (n == 1) {
            return 9;
        }

        long max = (long) (Math.pow (10, n) - 1);

        one:for (long i = max - 2; i > 0; i--) {
            long palindr = i;

            for (long x = palindr; x > 0; x /= 10) {
                palindr = palindr * 10 + x % 10;
            }

            for (long multiplier = max; multiplier * multiplier >= palindr; multiplier--) {
                if(palindr % multiplier == 0) {
                    ans = (int) (palindr % 1337);
                    break one;
                }
            }
        }

        return ans;
    }
}

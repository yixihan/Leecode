package com.yixihan.month13.day1112;

/**
 * description
 *
 * @author yixihan
 * @date 2022/11/12 21:54
 */
public class Solution {

    private static final long MOD = (long) 1e9 + 7;
    private static final long[] f = new long[1001];

    static {
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= 1000; ++i)
            f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
    }

    public int numTilings(int n) {
        return (int) f[n];
    }
}

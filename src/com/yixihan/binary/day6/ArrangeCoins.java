package com.yixihan.binary.day6;

/**
 * @author : yixihan
 * @create : 2022-04-02-12:08
 */
public class ArrangeCoins {
    public int arrangeCoins(int n) {

        // 方法一 : 暴力
        //        long sum = 0;
        //        int i;
        //        if (n == 1) {
        //            return 1;
        //        }
        //
        //        for (i = 1; i < n; i++) {
        //            sum += i;
        //            if (sum > n) {
        //                break;
        //            }
        //        }
        //
        //        return i - 1;

        // 方法二 : 数学求解
        //        return (int) (-1 + Math.sqrt (1 + 8 * (long) n)) / 2;

        // 方法三 : 二分
        long start = 0;
        long end = (long) n / 2 + 1;
        long mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }
}

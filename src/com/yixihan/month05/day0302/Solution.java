package com.yixihan.month05.day0302;

/**
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 * <p>
 * “最近的”定义为两个整数差的绝对值最小。
 * <p>
 * <p>
 * 输入: n = "123"
 * 输出: "121"
 * <p>
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 *
 * @author : yixihan
 * @create : 2022-03-02-12:14
 */
public class Solution {
    public String nearestPalindromic(String n) {
        long len = n.length();
        if (len == 1) {
            return String.valueOf(Integer.parseInt (n) - 1);
        }
        long me = Long.parseLong (n);
        boolean odd = (len & 1) == 1;
        long half = (len + 1) >> 1;
        char[] cs = n.toCharArray();
        long h = 0;
        int p = 0;
        while (p < half) {
            h = h * 10 + cs[p] - '0';
            p++;
        }
        long try1 = this.pal(h, half, odd);
        long try2 = this.pal(h - 1, half, odd);
        long try3 = this.pal(h + 1, half, odd);
        long try4 = (long) Math.pow(10, len - 1) - 1;
        long try5 = (long) Math.pow(10, len) + 1;
        long ans = try2;
        ans = this.findAns(me, ans, try1);
        ans = this.findAns(me, ans, try3);
        ans = this.findAns(me, ans, try4);
        ans = this.findAns(me, ans, try5);
        return String.valueOf(ans);
    }

    private long findAns(long me, long ans, long other) {
        if (me != other) {
            if (Math.abs(me - ans) > Math.abs(me - other)) {
                ans = other;
            } else if (Math.abs(me - ans) == Math.abs(me - other)) {
                ans = Math.min(ans, other);
            }
        }
        return ans;
    }

    private long pal(long try1, long len, boolean odd) {
        len -= odd ? 1 : 0;
        long basic = (long) Math.pow(10, len);
        long ans = try1 * basic;
        long mirror = 0;
        try1 = odd ? try1 / 10 : try1;
        while (try1 > 0) {
            long cur = try1 % 10;
            mirror = mirror * 10 + cur;
            try1 /= 10;
        }
        return ans + mirror;
    }

}

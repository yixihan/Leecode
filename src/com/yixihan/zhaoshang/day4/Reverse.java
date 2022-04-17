package com.yixihan.zhaoshang.day4;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 输入：x = 120
 * 输出：21
 * <p>
 * 输入：x = 0
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-04-17-15:26
 */
public class Reverse {
    public int reverse(int x) {

        String val = new StringBuilder (String.valueOf (Math.abs (x))).reverse ().toString ();
        if (val.charAt (val.length () - 1) == '-') {
            val = val.substring (0, val.length () - 1);
        }
        System.out.println (val);
        int ans = 0;
        try {
            ans = Integer.parseInt (val);
            return x < 0 ? -ans : ans;
        } catch (Exception e) {
            return ans;
        }


    }
}

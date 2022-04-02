package com.yixihan.month05.day0307;

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *
 * @author : yixihan
 * @create : 2022-03-07-11:24
 */
public class Solution {
    public String convertToBase7(int num) {
        // 方法一 :
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = Math.abs (num);
        } else if (num == 0) {
            return "0";
        }

        while (num > 0) {
            int val = num % 7;
            sb.append (val);
            num /= 7;
        }

        if (flag) {
            sb.append ("-");
        }

        return sb.reverse ().toString ();

        // 方法二 :
//        return Integer.toString (num, 7);
    }
}

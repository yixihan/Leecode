package com.yixihan.offer.day10;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * @author : yixihan
 * @create : 2022-03-02-12:52
 */
public class TranslateNum {

    public int translateNum(int num) {
        String value = String.valueOf (num);
        int length = value.length ();
        // 方式一
//        int[] dp = new int[length + 1];
//        dp[0] = dp[1] = 1;
//
//        for (int i = 2; i <= value.length(); i++) {
//            String tmpStr = value.substring(i - 2, i);
//            if (tmpStr.compareTo("10") >= 0 && tmpStr.compareTo("25") <= 0) {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            } else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[dp.length - 1];

        // 方式二
        int a = 1;
        int b = 1;

        for (int i = 2; i <= length; i++) {
            String substring = value.substring (i - 2, i);

            if (substring.compareTo ("10") >= 0 && substring.compareTo ("25") <= 0) {
                a = a + b;
                b = a - b;
            } else {
                b = a;
            }


        }
        return a;
    }
}

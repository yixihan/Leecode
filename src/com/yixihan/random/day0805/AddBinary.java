package com.yixihan.random.day0805;

/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author : yixihan
 * @create : 2022-08-05-16:58
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int lenA = a.length ();
        int lenB = b.length ();
        char[] arrA = a.toCharArray ();
        char[] arrB = b.toCharArray ();
        int indexA = lenA - 1;
        int indexB = lenB - 1;
        StringBuilder sb = new StringBuilder ();
        int tmp = 0;

        while (indexA >= 0 || indexB >= 0) {
            int num1 = indexA >= 0 ? arrA[indexA--] - '0' : 0;
            int num2 = indexB >= 0 ? arrB[indexB--] - '0' : 0;
            int sum = num1 + num2;
            if (tmp == 1) {
                sum++;
                tmp = 0;
            }
            if (sum >= 2) {
                tmp = 1;
                sum -= 2;
            }
            sb.append (sum);
        }

        if (tmp == 1) {
            sb.append (tmp);
        }

        return sb.reverse ().toString ();
    }
}

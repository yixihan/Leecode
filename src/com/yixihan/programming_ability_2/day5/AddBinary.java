package com.yixihan.programming_ability_2.day5;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author : yixihan
 * @create : 2022-03-27-13:17
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] arrA = a.toCharArray ();
        char[] arrB = b.toCharArray ();
        int n1 = arrA.length;
        int n2 = arrB.length;
        StringBuilder sb = new StringBuilder ();
        int i = n1 - 1;
        int j = n2 - 1;
        for (; i >= 0 || j >= 0; i--, j--) {
            int val = 0;

            if (j >= 0 && i >= 0) {
                val = (arrA[i] - '0') + (arrB[j] - '0');
            } else if (j < 0) {
                val = arrA[i] - '0';
            } else {
                val = arrB[j] - '0';
            }

            if (val < 2) {
                sb.append (val);
            } else {
                val -= 2;
                sb.append (val);
                if (i > 0) {
                    arrA[i - 1] += 1;
                } else if (j > 0) {
                    arrB[j - 1] += 1;
                } else {
                    sb.append (1);
                }
            }
        }

        return sb.reverse ().toString ();
    }
}

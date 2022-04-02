package com.yixihan.month05.day0225;

/**
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 *
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 *
 *
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 *
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 *
 * @author : yixihan
 * @create : 2022-02-25-13:09
 */
public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] arr1 = num1.split ("\\+");
        String[] arr2 = num2.split ("\\+");

        int num1R = Integer.parseInt (arr1[0]);
        int num2R = Integer.parseInt (arr2[0]);
        int num1I = Integer.parseInt (arr1[1].substring (0, arr1[1].length () - 1));
        int num2I = Integer.parseInt (arr2[1].substring (0, arr2[1].length () - 1));

        int n1 = num1R * num2R;
        int n2 = num1I * num2R + num1R * num2I;
        int n3 = num1I * num2I;

        return (n1 - n3) + "+" + n2 + "i";
    }
}

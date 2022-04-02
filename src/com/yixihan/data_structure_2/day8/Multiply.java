package com.yixihan.data_structure_2.day8;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * @author : yixihan
 * @create : 2022-03-31-0:46
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        char[] arr1 = num1.toCharArray ();
        char[] arr2 = num2.toCharArray ();
        int n1 = arr1.length - 1;
        int n2 = arr2.length - 1;

        if (n1 < 0 || n2 < 0) {
            return "";
        }
        int[] mul = new int[n1 + n2 + 2];

        for (int i = n1; i >= 0; --i) {
            for (int j = n2; j >= 0; --j) {
                int val = (arr1[i] - '0') * (arr2[j] - '0');
                val += mul[i + j + 1]; // 先加低位判断是否有新的进位

                mul[i + j] += val / 10;
                mul[i + j + 1] = val % 10;
            }
        }

        StringBuilder sb = new StringBuilder ();
        int i = 0;
        // 去掉前导0
        while (i < mul.length - 1 && mul[i] == 0) i++;
        for (; i < mul.length; ++i)
            sb.append (mul[i]);
        return sb.toString ();
    }
}

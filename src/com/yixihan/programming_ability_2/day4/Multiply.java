package com.yixihan.programming_ability_2.day4;

import java.util.Arrays;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * @author : yixihan
 * @create : 2022-03-26-8:36
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        int n1 = num1.length ();
        int n2 = num2.length ();

        char[] arr1 = num1.toCharArray ();
        char[] arr2 = num2.toCharArray ();
        int[] num3 = new int[n1 + n2 + 2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                num3[i + j] += (arr1[i] - '0') * (arr2[j] - '0');
            }

            System.out.println (Arrays.toString (num3));
        }

        int index = n1 + n2 - 2;

        StringBuilder ans = new StringBuilder ();

        for (int i = index; i > 0; i--) {
            // System.out.println (num3[i]);
            while (num3[i] >= 10) {
                num3[i - 1] += 1;
                num3[i] -= 10;
            }
            ans.append (num3[i]);
            // System.out.println ("ans : " + ans);
        }
        if (num3[0] == 0) {
            return "0";
        }
        while (num3[0] > 0) {
            ans.append (num3[0] % 10);
            num3[0] /= 10;
        }
        // System.out.println ("ans : " + ans);


        return ans.reverse ().toString ();
    }


}

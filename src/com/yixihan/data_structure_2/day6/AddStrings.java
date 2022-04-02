package com.yixihan.data_structure_2.day6;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 * @author : yixihan
 * @create : 2022-03-29-8:45
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray ();
        char[] arr2 = num2.toCharArray ();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] num = new int[Math.max (n1, n2) + 1];
        int index = 0;
        for (int i = n1 - 1, j = n2 - 1; i >= 0 || j >= 0; i--, j--) {
            int val = 0;
            val += i >= 0 ? arr1[i] - '0' : 0;
            val += j >= 0 ? arr2[j] - '0' : 0;
            num[index] += val;
            if (num[index] >= 10) {
                num[index] -= 10;
                num[index + 1] += 1;
            }
            index++;
        }

        // System.out.println (Arrays.toString (num));

        StringBuilder sb = new StringBuilder (num.length);
        int i;
        for (i = num.length - 1; i >= 0; i--) {
            if (num[i] != 0) {
                break;
            }
        }
        System.out.println (i);
        if (i < 0) {
            return "0";
        }
        for (; i >= 0; i--) {
            sb.append (num[i]);
        }

        return sb.toString ();

    }
}

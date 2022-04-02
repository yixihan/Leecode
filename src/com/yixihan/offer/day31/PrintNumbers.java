package com.yixihan.offer.day31;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * @author : yixihan
 * @create : 2022-03-22-10:33
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int[] ans = new int[(int) Math.pow (10, n) - 1];
        System.out.println (Math.pow (10, n) - 1);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i + 1;
        }

        return ans;
    }
}

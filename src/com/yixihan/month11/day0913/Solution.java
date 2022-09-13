package com.yixihan.month11.day0913;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * <p>
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 *
 * @author : yixihan
 * @create : 2022-09-13-10:58
 */
public class Solution {

    public int maximumSwap(int num) {
        char[] arr = String.valueOf (num).toCharArray ();
        int[] maxIndex = new int[arr.length];
        int max = arr.length - 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > arr[max]) {
                max = i;
            }
            maxIndex[i] = max;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[maxIndex[i]]) {
                char tmp = arr[i];
                arr[i] = arr[maxIndex[i]];
                arr[maxIndex[i]] = tmp;
                break;
            }
        }

        return Integer.parseInt (new String (arr));
    }
}

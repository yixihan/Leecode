package com.yixihan.programming_ability_2.day10;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。
 * 如果不存在这样的正整数，则返回 -1 。
 * <p>
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 * 输入：n = 12
 * 输出：21
 * <p>
 * 输入：n = 21
 * 输出：-1
 *
 * @author : yixihan
 * @create : 2022-04-01-14:34
 */
public class NextGreaterElement {

    /**
     * 从右往左遍历 找到第一个不是顺序排列的数字,而不是第一个比最右的数小的数
     *
     * 找到了这个数i之后再最后的数开始往右遍历,找到第一个比i大的数j与i交换,然后再对i后面的所有数重新排序
     */
    public int nextGreaterElement(int n) {
        String val = String.valueOf (n);
        char[] arr = val.toCharArray ();
        int len = arr.length;

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                for (int j = len - 1; j > i; j--) {
                    if (arr[j] > arr[i]) {
                        char tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                        Arrays.sort (arr, i + 1, len);
                        break;
                    }
                }
                break;
            }
        }
        int ans;
        try {
            ans = Integer.parseInt (new String (arr));
        } catch (Exception e) {
            return -1;
        }
        if (ans  == n) {
            return -1;
        } else {
            return ans;
        }
    }
}

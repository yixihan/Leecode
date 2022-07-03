package com.yixihan.month09.day0703;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
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
 * @create : 2022-07-03-9:19
 */
public class Solution {

    public int nextGreaterElement(int n) {
        char[] num = String.valueOf (n).toCharArray ();
        int len = num.length;

        for (int i = len - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                for (int j = len - 1; j > i; j--) {
                    if (num[j] > num[i]) {
                        char tmp = num[j];
                        num[j] = num[i];
                        num[i] = tmp;
                        Arrays.sort (num, i + 1, len);
                        break;
                    }
                }
                break;
            }
        }
        int ans;
        try {
            ans = Integer.parseInt (new String (num));
        } catch (Exception e) {
            return -1;
        }
        if (ans == n) {
            return -1;
        } else {
            return ans;
        }
    }
}

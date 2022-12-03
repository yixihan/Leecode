package com.yixihan.month14.day1203;

/**
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 *
 * 混合字符串 由小写英文字母和数字组成。
 *
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 *
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *
 *
 * @author yixihan
 * @date 2022/12/3 14:52
 */
public class Solution {
    
    public int secondHighest(String s) {
        int[] letters = new int[10];
        
        for (char c : s.toCharArray ()) {
            if (c >= '0' && c <= '9') {
                letters[c - '0']++;
            }
        }
        boolean flag = false;
        for (int i = letters.length - 1; i >= 0; i--) {
            if (!flag &&letters[i] != 0) {
                flag = true;
            } else if (flag && letters[i] != 0) {
                return i;
            }
        }
        
        return -1;
    }
}

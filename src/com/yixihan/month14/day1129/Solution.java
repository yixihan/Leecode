package com.yixihan.month14.day1129;

/**
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * <p>
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * <p>
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * <p>
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 * <p>
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 * <p>
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 *
 * @author yixihan
 * @date 2022/11/29 15:11
 */
public class Solution {
    
    public int minOperations(String s) {
        int zero = 0;
        int one = 0;
        int index = 0;
        for (char c : s.toCharArray ()) {
            if (c == '0') {
                if (index % 2 == 0) {
                    zero++;
                } else {
                    one++;
                }
            } else {
                if (index % 2 == 0) {
                    one++;
                } else {
                    zero++;
                }
            }
            index++;
        }
        
        return Math.abs (zero - one);
    }
}

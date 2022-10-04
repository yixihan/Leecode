package com.yixihan.month12.day1003;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 *
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true​​​ 。否则，返回 false 。
 *
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 *
 * 输入：s = "110"
 * 输出：true
 *
 * @author yixihan
 * @date 2022-10-03-20:55
 */
public class Solution {

    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        boolean flag = false;

        for (char c : s.toCharArray ()) {
            if (!flag && c == '1') {
                cnt++;
                flag = true;
            } else if (flag && c == '0') {
                flag = false;
            }

            if (cnt > 1) {
                return false;
            }
        }

        return true;
    }
}

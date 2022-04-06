package com.yixihan.binary.day10;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 输入：c = 3
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-04-06-13:15
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt (c);

        // -c 判断正负性, 防止溢出
        while (left <= right) {
            int val = left * left - c + right * right;

            if (val > 0) {
                right--;
            } else if (val < 0) {
                left++;
            } else {
                return true;
            }

        }

        return false;
    }
}

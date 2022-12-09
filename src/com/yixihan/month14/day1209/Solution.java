package com.yixihan.month14.day1209;

/**
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * <p>
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * <p>
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * <p>
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * <p>
 * 输入：n = 21
 * 输出：false
 *
 * @author yixihan
 * @date 2022/12/9 9:11
 */
public class Solution {
    
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 > 1) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}

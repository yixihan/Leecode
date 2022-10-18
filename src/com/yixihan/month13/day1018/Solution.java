package com.yixihan.month13.day1018;

import java.util.Arrays;

/**
 * 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。
 * 例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
 * <p>
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
 * <p>
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * <p>
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * <p>
 * 输入：digits = ["7"], n = 8
 * 输出：1
 *
 * @author yixihan
 * @date 2022-10-18-8:59
 */
public class Solution {

    private String[] digits;
    private char[] s;
    private int[] dp;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        s = Integer.toString (n).toCharArray ();
        dp = new int[s.length];
        Arrays.fill (dp, -1); // dp[i] = -1 表示 i 这个状态还没被计算出来
        return f (0, true, false);
    }

    private int f(int i, boolean isLimit, boolean isNum) {
        if (i == s.length) return isNum ? 1 : 0; // 如果填了数字，则为 1 种合法方案
        if (!isLimit && isNum && dp[i] >= 0) return dp[i]; // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
        int res = 0;
        if (!isNum) // 前面不填数字，那么可以跳过当前数位，也不填数字
            // isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
            // isNum 仍然为 false，因为没有填任何数字
            res = f (i + 1, false, false);
        int up = isLimit ? s[i] : '9'; // 根据是否受到约束，决定可以填的数字的上限
        // 注意：对于一般的题目而言，如果此时 isNum 为 false，则必须从 1 开始枚举，由于本题 digits 没有 0，所以无需处理这种情况
        for (String d : digits) { // 枚举要填入的数字 d
            if (d.charAt (0) > up) break; // d 超过上限，由于 digits 是有序的，后面的 d 都会超过上限，故退出循环
            // isLimit：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
            // isNum 为 true，因为填了数字
            res += f (i + 1, isLimit && d.charAt (0) == up, true);
        }
        if (!isLimit && isNum) dp[i] = res; // 在不受到任何约束的情况下，记录结果
        return res;
    }

}

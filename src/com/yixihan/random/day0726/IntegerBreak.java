package com.yixihan.random.day0726;

/**
 * 给定一个正整数n，将其拆分为 k 个 正整数 的和（k >= 2），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积。
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
 *
 * @author : yixihan
 * @create : 2022-07-26-8:37
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int ans = 1;

        while (n > 4) {
            n -= 3;
            ans *= 3;
        }

        return ans * n;
    }
}

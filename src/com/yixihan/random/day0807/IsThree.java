package com.yixihan.random.day0807;

/**
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
 * <p>
 * 输入：n = 2
 * 输出：false
 * 解释：2 只有两个除数：1 和 2 。
 * <p>
 * 输入：n = 4
 * 输出：true
 * 解释：4 有三个除数：1、2 和 4 。
 *
 * @author : yixihan
 * @create : 2022-08-07-10:27
 */
public class IsThree {

    public boolean isThree(int n) {
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }

            if (cnt > 3) {
                return false;
            }
        }

        return true;
    }
}

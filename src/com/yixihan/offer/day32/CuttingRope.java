package com.yixihan.offer.day32;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * @author : yixihan
 * @create : 2022-03-23-12:50
 */
public class CuttingRope {

    static final long MOD = 1000000007;

    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }

        long ans = 1;

        while (n > 4) {
            ans = (ans * 3) % MOD;
            n -= 3;
        }

        return (int) (ans * n % MOD);
    }
}

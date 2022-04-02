package com.yixihan.month05.day0222;

/**
 * 给你一个整数数组 nums 。如果 nums 的一个子集中，所有元素的乘积可以表示为一个或多个 互不相同的质数 的乘积，那么我们称它为 好子集 。
 * <p>
 * 比方说，如果 nums = [1, 2, 3, 4] ：
 * [2, 3] ，[1, 2, 3] 和 [1, 3] 是 好 子集，乘积分别为 6 = 2*3 ，6 = 2*3 和 3 = 3 。
 * [1, 4] 和 [4] 不是 好 子集，因为乘积分别为 4 = 2*2 和 4 = 2*2 。
 * 请你返回 nums 中不同的 好 子集的数目对 109 + 7 取余 的结果。
 * <p>
 * nums 中的 子集 是通过删除 nums 中一些（可能一个都不删除，也可能全部都删除）元素后剩余元素组成的数组。
 * 如果两个子集删除的下标不同，那么它们被视为不同的子集。
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：6
 * 解释：好子集为：
 * - [1,2]：乘积为 2 ，可以表示为质数 2 的乘积。
 * - [1,2,3]：乘积为 6 ，可以表示为互不相同的质数 2 和 3 的乘积。
 * - [1,3]：乘积为 3 ，可以表示为质数 3 的乘积。
 * - [2]：乘积为 2 ，可以表示为质数 2 的乘积。
 * - [2,3]：乘积为 6 ，可以表示为互不相同的质数 2 和 3 的乘积。
 * - [3]：乘积为 3 ，可以表示为质数 3 的乘积。
 * <p>
 * 输入：nums = [4,2,3,15]
 * 输出：5
 * 解释：好子集为：
 * - [2]：乘积为 2 ，可以表示为质数 2 的乘积。
 * - [2,3]：乘积为 6 ，可以表示为互不相同质数 2 和 3 的乘积。
 * - [2,15]：乘积为 30 ，可以表示为互不相同质数 2，3 和 5 的乘积。
 * - [3]：乘积为 3 ，可以表示为质数 3 的乘积。
 * - [15]：乘积为 15 ，可以表示为互不相同质数 3 和 5 的乘积。
 *
 * @author : yixihan
 * @create : 2022-02-22-11:18
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;
    int[] p = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    int[] cnts = new int[31];

    public int numberOfGoodSubsets(int[] nums) {

        int n = nums.length;

        for (int num : nums) {
            cnts[num]++;
        }

        // dp[3]  5 二进制位 0000000101, 表示子集所有元素乘积为 p[0] * p[2] = 2 * 5 的个数
        // 动态转移方式为在已有的情况下再增加其他质数  (p[0] * p[2]) * p[2] = (2 * 5) * 3
        // 注意这里 dp 用 int 会溢出
        int mask = 1 << p.length;
        long[] dp = new long[mask];
        dp[0] = 1;

        for (int i = 2; i <= 30; i++) {
            if (cnts[i] == 0) {
                continue;
            }

            // 对 i 进行试除
            // x 用来你分解质因数， cur 二进制位用来记录分解出现的质因数位置
            int cur = 0;
            int x = i;
            boolean ok = true;

            for (int j = 0; j < p.length; j++) {
                int t = p[j];
                int c = 0;

                while (x % t == 0) {
                    cur |= (1 << j);
                    x /= t;
                    c++;
                }

                // 如果 i 能够被同一质数试除多次, 说明 i 不能添加到子集, 跳过
                if (c > 1) {
                    ok = false;
                    break;
                }

            }

            if (!ok) {
                continue;
            }

            // 枚举前一状态 prev，注意需要倒序遍历
            //（确保考虑一个新数值 i 时，依赖的子集 prev 存储的为尚未考虑 i 的方案数）
            for (int prev = mask - 1; prev >= 0; prev--) {
                // 只有当前选择数与前一状态不冲突，则能够进行转移，将方案数进行累加
                if ((prev & cur) != 0) continue;
                dp[prev | cur] = (dp[prev | cur] + dp[prev] * cnts[i]) % MOD;
            }
        }

        long ans = 0;

        // 统计所有非空集的方案数
        for (int i = 1; i < mask; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        // 在此基础上，考虑每个 1 选择与否对答案的影响
        for (int i = 0; i < cnts[1]; i++) {
            ans = ans * 2 % MOD;
        }

        return (int) ans;
    }
}

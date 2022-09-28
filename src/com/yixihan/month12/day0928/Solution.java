package com.yixihan.month12.day0928;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * <p>
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 *
 * @author yixihan
 * @date 2022-09-28-8:53
 */
public class Solution {

    public int getKthMagicNumber(int k) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] ans = new int[k];
        ans[0] = 1;

        for (int i = 1; i < k; i++) {
            ans[i] = Math.min (ans[a] * 3, Math.min (ans[b] * 5, ans[c] * 7));
            a += ans[i] == ans[a] * 3 ? 1 : 0;
            b += ans[i] == ans[b] * 5 ? 1 : 0;
            c += ans[i] == ans[c] * 7 ? 1 : 0;
        }

        return ans[k - 1];
    }
}

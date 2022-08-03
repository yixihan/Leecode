package com.yixihan.random.day0803;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 输入：nums = [2,4]
 * 输出：6
 * <p>
 * 输入：nums = [8,10,2]
 * 输出：10
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 * @author : yixihan
 * @create : 2022-08-03-9:05
 */
public class FindMaximumXOR {

    static int N = (int) 1e6;
    static int[][] trie = new int[N][2];
    static int idx = 0;

    public FindMaximumXOR() {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill (trie[i], 0);
        }
        idx = 0;
    }

    private void add(int x) {
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (trie[p][u] == 0) {
                trie[p][u] = ++idx;
            }
            p = trie[p][u];
        }
    }

    private int getVal(int x) {
        int ans = 0;
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1;
            int b = 1 - a;
            if (trie[p][b] != 0) {
                ans |= (b << i);
                p = trie[p][b];
            } else {
                ans |= (a << i);
                p = trie[p][a];
            }
        }

        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;

        for (int i : nums) {
            add (i);
            int j = getVal (i);
            ans = Math.max (ans, i ^ j);
        }

        return ans;
    }
}

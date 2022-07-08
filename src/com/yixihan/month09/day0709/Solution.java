package com.yixihan.month09.day0709;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * <p>
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
 * 例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * <p>
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 *
 * @author : yixihan
 * @create : 2022-07-09-6:48
 */
public class Solution {

    /**
     * 定义状态
     * dp[i][j]表示以A[i]，A[j]结尾的最长斐波那契子序列长度。
     *
     * 转移方程
     * dp[i][j] = MAX(dp[k][i] + 1) 满足 k < i < j，且A[k] = A[j] - A[i]。
     *
     * 使用一个map，将A[i]与i映射起来。即 map[A[i]] = i。
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0;
        int sum;
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }

        int l;
        int r;

        for (int i = 1; i < n; i++) {
            l = 0;
            r = n - 1;

            while (l < r) {
                sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    dp[r][i] = Math.max (dp[r][i], dp[l][r] + 1);
                    ans = Math.max (dp[r][i], ans);
                    l++;
                    r--;
                } else if (sum < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return ans;
    }
}

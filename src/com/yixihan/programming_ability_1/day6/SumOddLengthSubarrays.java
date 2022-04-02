package com.yixihan.programming_ability_1.day6;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * @author : yixihan
 * @create : 2022-03-16-13:29
 */
public class SumOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {

        // 方法一 : 暴力解
//        int ans = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j >= 0; j--) {
//                if ((i - j) % 2 == 0) {
//                    for (int k = j; k <= i; k++) {
//                        ans += arr[k];
//                    }
//                }
//            }
//        }
//
//        return ans;

        // 方法二 : 前缀和
        int ans = 0;
        int n = arr.length;
        int[] pre = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j -= 2) {
                ans += pre[i + 1] - pre[j];
            }
        }

        return ans;

        // 方法三 : 据说这是一道规律题
//        if (arr.length == 1) {
//            return arr[0];
//        }
//        int n = arr.length;
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum = sum + arr[i] * ((i / 2 + 1) * ((n - i - 1) / 2 + 1) + ((i + 1) / 2) * ((n - i) / 2));
//        }
//        return sum;
    }
}

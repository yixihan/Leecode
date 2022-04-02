package com.yixihan.binary.day6;

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 *
 * @author : yixihan
 * @create : 2022-04-02-12:39
 */
public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        for (int j : arr) {
            if (j <= k) {
                k++;
            }
        }

        return k;
    }
}

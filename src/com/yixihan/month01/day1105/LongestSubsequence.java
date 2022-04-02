package com.yixihan.month01.day1105;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 * 
 * @author : yixihan
 * @create : 2021-11-05-12:07
 */
public class LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<>(arr.length);
        for (int j : arr) {

            Integer val = map.get(j - difference);

            if (val != null) {
                map.put(j, val + 1);
                max = Math.max(max, val + 1);
            } else {
                map.put(j, 1);
            }
        }
        return max;

    }

    @Test
    public void test () {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        System.out.println(longestSubsequence(arr, -2));
    }
}

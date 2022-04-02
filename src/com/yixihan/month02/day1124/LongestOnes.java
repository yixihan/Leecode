package com.yixihan.month02.day1124;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * @author : yixihan
 * @create : 2021-11-24-17:02
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {

        int res = 0;

        int temp;
        int count;

        for (int i = 0; i < nums.length; i++) {

            temp = k;
            count = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] != 1) {
                    temp--;
                }
                if (temp < 0) {
                    break;
                }
                count++;

            }

            res = Math.max(res, count);
            if (nums.length - i < res) {
                break;
            }
        }
        return res;
    }

    /**
     * 窗口滑动
     */
    public int longestOnes1(int[] nums, int k) {
        int N = nums.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;

        while (right < N) {

            if (nums[right] == 0)
                zeros ++;

            while (zeros > k) {

                if (nums[left++] == 0)
                    zeros --;
            }

            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }

}

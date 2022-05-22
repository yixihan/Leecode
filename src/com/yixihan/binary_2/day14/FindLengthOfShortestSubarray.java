package com.yixihan.binary_2.day14;

/**
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 * <p>
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * <p>
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * <p>
 * 输入：arr = [1]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-05-22-9:16
 */
public class FindLengthOfShortestSubarray {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start + 1 < n && arr[start] <= arr[start + 1]) {
            start++;
        }

        while (end >= 1 && arr[end] >= arr[end - 1]) {
            end--;
        }

        if (start >= end) {
            return 0;
        }

        int minLen = Math.min (n - start - 1, end);

        for (int i = end; i < n; i++) {
            int tmp = arr[i];
            int left = 0;
            int right = start + 1;

            while (left < right) {
                int mid = (left + right) >> 1;
                if (arr[mid] > tmp) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            minLen = Math.min (minLen, i - left);
        }

        return minLen;
    }
}

package com.yixihan.month14.day1207;

import java.util.Arrays;

/**
 * 给你两个长度可能不等的整数数组  nums1 和  nums2  。两个数组中的所有值都在  1  到  6  之间（包含  1  和  6）。
 * <p>
 * 每次操作中，你可以选择 任意  数组中的任意一个整数，将它变成 1  到 6  之间 任意  的值（包含 1  和 6）。
 * <p>
 * 请你返回使 nums1  中所有数的和与  nums2  中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1  。
 * <p>
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * <p>
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * <p>
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 *
 * @author yixihan
 * @date 2022/12/7 8:57
 */
public class Solution {
    
    public int minOperations(int[] nums1, int[] nums2) {
        int s1 = Arrays.stream (nums1).sum ();
        int s2 = Arrays.stream (nums2).sum ();
        if (s1 == s2) {
            return 0;
        }
        if (s1 > s2) {
            return minOperations (nums2, nums1);
        }
        int d = s2 - s1;
        int[] cnt = new int[6];
        for (int v : nums1) {
            ++cnt[6 - v];
        }
        for (int v : nums2) {
            ++cnt[v - 1];
        }
        int ans = 0;
        for (int i = 5; i > 0; --i) {
            while (cnt[i] > 0 && d > 0) {
                d -= i;
                --cnt[i];
                ++ans;
            }
        }
        return d <= 0 ? ans : -1;
    }
}

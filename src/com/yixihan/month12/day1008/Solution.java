package com.yixihan.month12.day1008;

import java.util.Arrays;

/**
 * 给定两个大小相等的数组 nums1 和 nums2，
 * nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 * @author yixihan
 * @date 2022-10-08-9:20
 */
public class Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int minIndex = 0;
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        Arrays.sort (nums1);

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n;

            while (left != right) {
                int mid = left + ((right - left) >> 1);
                if (nums1[mid] < nums2[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            while (left < n && (visited[left] || nums1[left] == nums2[i])) {
                left++;
            }
            if (left == n) {
                while (visited[minIndex]) {
                    minIndex++;
                }
                ans[i] = nums1[minIndex];
                visited[minIndex++] = true;
            } else {
                visited[left] = true;
                ans[i] = nums1[left];
            }
        }
        return ans;
    }
}

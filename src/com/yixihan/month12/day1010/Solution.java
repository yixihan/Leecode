package com.yixihan.month12.day1010;

/**
 * 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 * <p>
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 * <p>
 * 数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
 * <p>
 * 注意：
 * <p>
 * 用例保证可以实现操作。
 * <p>
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * <p>
 * 输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
 * 输出: 1
 *
 * @author yixihan
 * @date 2022-10-10-9:15
 */
public class Solution {

    public int minSwap(int[] nums1, int[] nums2) {
        int a = 0, b = 1;
        for (int i = 1; i < nums1.length; ++i) {
            int x = a, y = b;
            if (nums1[i - 1] >= nums1[i] || nums2[i - 1] >= nums2[i]) {
                a = y;
                b = x + 1;
            } else {
                b = y + 1;
                if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                    a = Math.min (a, y);
                    b = Math.min (b, x + 1);
                }
            }
        }
        return Math.min (a, b);
    }
}

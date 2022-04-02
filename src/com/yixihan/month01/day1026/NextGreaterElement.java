package com.yixihan.month01.day1026;

import org.junit.jupiter.api.Test;

/**
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 * @author : yixihan
 * @create : 2021-10-26-13:56
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    int k = j + 1;
                    for (; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }

                    if (k >= nums2.length) {
                        res[i] = -1;
                    }
                }
            }
        }

        return res;
    }

    @Test
    public void test () {
        int[] ints = nextGreaterElement(new int[]{4, 1, 2}, new int[]{1,3,4,2});

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

package com.yixihan.binary.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * @author : yixihan
 * @create : 2022-04-06-13:12
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort (nums1);
        Arrays.sort (nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> list = new ArrayList<> (Math.min (n1, n2));

        for (int i = 0, j = 0; i < n1 && j < n2; ) {
            if (nums1[i] == nums2[j]) {
                list.add (nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[list.size ()];
        int index = 0;
        for (Integer val : list) {
            ans[index++] = val;
        }

        return ans;
    }
}

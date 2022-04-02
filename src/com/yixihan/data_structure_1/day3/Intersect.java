package com.yixihan.data_structure_1.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 * <p>
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * @author : yixihan
 * @create : 2022-03-12-11:52
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 方法一 : 集合暴力解
        //        List<Integer> list1 = new ArrayList<> ();
        //        List<Integer> list2 = new ArrayList<>();
        //        int n = nums1.length;
        //        int m = nums2.length;
        //
        //        for (int num1 : nums1) {
        //            list1.add (num1);
        //        }
        //
        //        for (int num2 : nums2) {
        //            if (list1.contains (num2)) {
        //                list2.add (num2);
        //                list1.remove (Integer.valueOf(num2));
        //            }
        //        }
        //
        //
        //        int[] ans = new int[list2.size ()];
        //        int index = 0;
        //
        //        for (int val : list2) {
        //            ans[index++] = val;
        //        }
        //
        //        return ans;

        // 方法二 : 排序后双指针顺序查找相同的数
        Arrays.sort (nums1);
        Arrays.sort (nums2);

        List<Integer> list = new ArrayList<> ();
        int num1 = 0;
        int num2 = 0;

        while (num1 < nums1.length && num2 < nums2.length) {
            if (nums1[num1] < nums2[num2]) {
                num1++;
            } else if (nums1[num1] > nums2[num2]) {
                num2++;
            } else {
                list.add (nums1[num1]);
                num1++;
                num2++;
            }
        }

        int[] ans = new int[list.size ()];
        int index = 0;

        for (int val : list) {
            ans[index++] = val;
        }

        return ans;

    }

}

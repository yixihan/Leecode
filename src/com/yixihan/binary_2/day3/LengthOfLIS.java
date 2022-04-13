package com.yixihan.binary_2.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-04-13-13:31
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<> ();

        for (int num : nums) {

            // list 为空, 直接放入
            if (list.isEmpty ()) {
                list.add (num);
            }

            // num > list 中最后一个元素, 直接放入
            if (num > list.get (list.size () - 1)) {
                list.add (num);
            }

            // 二分查找需要替换的位置
            int l = 0;
            int r = list.size () - 1;

            while (l < r) {
                int mid = (l + r) >> 1;

                if (list.get (mid) >= num) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            // 替换
            list.set (l, num);
        }

        return list.size ();
    }
}

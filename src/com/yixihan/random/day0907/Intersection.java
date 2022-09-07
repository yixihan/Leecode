package com.yixihan.random.day0907;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 * @author : yixihan
 * @create : 2022-09-07-13:45
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<> ();

        for (int j : nums1) {
            if (set.contains (j)) {
                continue;
            }
            for (int k : nums2) {
                if (j == k) {
                    set.add (j);
                    break;
                }
            }
        }
        int[] ans = new int[set.size ()];
        int index = 0;
        for (int val : set) {
            ans[index++] = val;
        }

        return ans;
    }
}

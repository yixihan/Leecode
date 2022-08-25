package com.yixihan.month11.day0825;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 * @author : yixihan
 * @create : 2022-08-25-12:15
 */
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (r - l >= k) {
            int diffL = Math.abs (arr[l] - x);
            int diffR = Math.abs (arr[r] - x);

            if (diffL > diffR) {
                l++;
            } else {
                r--;
            }
        }

        List<Integer> ans = new ArrayList<> (k);

        for (int i = l; i <= r; i++) {
            ans.add (arr[i]);
        }

        return ans;
    }
}

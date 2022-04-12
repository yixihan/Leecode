package com.yixihan.binary_2.day2;

import java.util.ArrayList;
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
 * @create : 2022-04-12-10:35
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 暴力
        //        int n = arr.length;
        //        int left = 0;
        //        int right = n - 1;
        //        List<Integer> ans = new ArrayList<> (k);
        //        int index = binarySearch (arr, left, right, x);
        //
        //        int indexL = index - 1;
        //        int indexR = index;
        //
        //        while (ans.size () < k) {
        //            int valL = indexL >= 0 ? arr[indexL] : 100000;
        //            int valR = indexR < n ? arr[indexR] : 100000;
        //
        //            if (Math.abs (valL - x) == Math.abs (valR - x)) {
        //                if (valL < valR) {
        //                    indexL--;
        //                    ans.add (valL);
        //                } else {
        //                    indexR++;
        //                    ans.add (valR);
        //                }
        //            } else if (Math.abs (valL - x) > Math.abs (valR - x)) {
        //                indexR++;
        //                ans.add (valR);
        //            } else {
        //                indexL--;
        //                ans.add (valL);
        //            }
        //
        //        }
        //
        //        ans.sort (Integer::compareTo);
        //
        //        return ans;

        // 滑动窗口
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

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}

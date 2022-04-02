package com.yixihan.month02.day1129;

import java.util.*;

/**
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 *
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 *
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 *
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * 
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 * @author : yixihan
 * @create : 2021-11-29-13:41
 */
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int length = arr.length;
        List<Double> list = new ArrayList<>();
        Map<Double, int[]> map = new HashMap<>();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                double val = ((double) arr[i] / arr[j]);
                list.add(val);
                map.put(val, new int[]{arr[i], arr[j]});
            }
        }

        list.sort(Double::compare);

        return map.get(list.get(k - 1));
    }

    // 二分 + 双指针

    double eps = 1e-8;
    int[] arr;
    int n, a, b;

    public int[] kthSmallestPrimeFraction1(int[] _arr, int k) {
        arr = _arr;
        n = arr.length;
        double l = 0, r = 1;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid) >= k) {
                r = mid;
            }
            else {
                l = mid;
            }
        }
        return new int[]{a, b};
    }

    int check(double x){
        int ans = 0;

        for (int i = 0, j = 1; j < n; j++) {
            while (arr[i + 1] * 1.0 / arr[j] <= x) {
                i++;
            }
            if (arr[i] * 1.0 / arr[j] <= x) {
                ans += i + 1;
            }
            if (Math.abs(arr[i] * 1.0 / arr[j] - x) < eps) {
                a = arr[i]; b = arr[j];
            }
        }
        return ans;
    }

}

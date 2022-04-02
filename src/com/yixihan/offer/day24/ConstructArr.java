package com.yixihan.offer.day24;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 
 * B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * @author : yixihan
 * @create : 2022-03-15-11:16
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {

        if (a == null || a.length == 0) {
            return new int[]{};
        }

        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = a[0];
        right[n - 1] = a[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i];
        }

        for (int j = n - 2; j >= 0; j--) {
            right[j] = right[j + 1] * a[j];
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[i] = right[i + 1];
            } else if (i == n - 1) {
                ans[i] = left[i - 1];
            } else {
                ans[i] = left[i - 1] * right[i + 1];
            }
        }

        return ans;

    }
}

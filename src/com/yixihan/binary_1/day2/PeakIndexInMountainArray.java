package com.yixihan.binary_1.day2;

/**
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，
 * 返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * <p>
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * <p>
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-03-29-8:44
 */
public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && mid < n - 1) {
                if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    right = mid - 1;
                } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (mid <= 0) {
                left += 1;
            } else if (right >= n - 1) {
                right -= 1;
            }

        }

        return -1;
    }
}

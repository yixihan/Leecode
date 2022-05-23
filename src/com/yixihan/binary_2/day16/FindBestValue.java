package com.yixihan.binary_2.day16;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
 * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *
 * @author : yixihan
 * @create : 2022-05-24-0:32
 */
public class FindBestValue {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort (arr);
        int preSum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            double tmp = (double) (target - preSum) / (n - i);

            if (arr[i] > tmp) {
                return (int) (tmp + 0.4);
            }

            preSum += arr[i];
        }

        return arr[n - 1];
    }
}

package com.yixihan.offer.day17;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author : yixihan
 * @create : 2022-03-09-11:56
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort (arr);

        System.arraycopy (arr, 0, ans, 0, k);

        return ans;
    }
}

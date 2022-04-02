package com.yixihan.month02.day1122;

import java.util.Random;

/**
 * @author : yixihan
 * @create : 2021-11-22-0:13
 */
public class Solution {

    int[] arr;
    int[] copy;
    int n;

    public Solution(int[] nums) {
        arr = nums;
        n = nums.length;
        copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
    }

    public int[] reset() {
        return copy;
    }

    public int[] shuffle() {
        Random r = new Random();

        //随机出一个符合范围的数,交换两个位置的元素,再不断的缩小范围
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        return arr;
    }

}

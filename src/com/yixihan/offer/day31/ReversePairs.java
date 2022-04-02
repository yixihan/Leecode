package com.yixihan.offer.day31;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * @author : yixihan
 * @create : 2022-03-22-11:10
 */
public class ReversePairs {
    int count = 0;

    public int reversePairs(int[] nums) {

        mergeSort (nums);
        System.out.println (Arrays.toString (nums));

        return count;
    }

    private void mergeSort (int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int[] temp = new int[arr.length];
        mergeSort (arr, left, right, temp);
    }

    private void mergeSort (int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            // 中间索引
            int middle = (left + right) / 2;

            // 向左递归进行分解
            mergeSort(arr, left, middle, temp);

            // 向右递归进行分解
            mergeSort(arr, middle + 1, right, temp);

            // 到合并时, 每分解一次, 就合并一次
            merge(arr, left, middle, right, temp);
        }
    }

    private void merge (int[] arr, int left, int middle, int right, int[] temp) {
        // 初始化 i, 左边有序序列的初始索引
        int i = left;
        // 初始化 j, 右边有序序列的初始索引
        int j = middle + 1;
        // 指向 temp 数组的当前索引
        int t = 0;

        // 1. 先把左右两边 (已经有序) 的数据按照规则填充到 temp 数组中
        // 直到左右两边的有序序列, 有一方处理完毕为止

        while (i <= middle && j <= right) {

            // 如果左边有序序列的当前元素小于等于右边有序序列的当前元素
            // 就将左边的当前元素填充到 temp 数组中 temp[t++] = arr[i++];
            // 反之将右边有序序列的当前元素填充到 temp 数组中 temp[t++] = arr[j++];
            if (arr[i] <= arr[j]) {
                // 注意 : t 和 i 都需要后移一位, 先填充, 后位移
                temp[t++] = arr[i++];
            } else {
                // 注意 : t 和 j 都需要后移一位, 先填充, 后位移
                temp[t++] = arr[j++];
                count += (middle - i + 1);
            }

        }

        // 2. 将有剩余数据的一方, 依次填充到 temp 数组中

        // 判断左边的有序序列是否还有剩余的元素, 如果有, 就全部填充到 temp 中
        while (i <= middle) {
            temp[t++] = arr[i++];
        }

        // 判断右边的有序序列是否还有剩余的元素, 如果有, 就全部填充到 temp 中
        while ((j <= right)) {
            temp[t++] = arr[j++];
        }

        // 3. 将 temp 数组的元素拷贝到 arr 数组中
        // 注意 : 并不是每次都是拷贝所有的元素到 arr 数组中
        t = 0;
        int tempLeft = left;

        // 第一次合并时, tempLeft = 0, right = 1
        // 第二次合并时, tempLeft = 2, right = 3
        // 第三次合并时, tempLeft = 0, right = 3
        // ...
        // 最后一次合并时, tempLeft = 0, right = length - 1
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}

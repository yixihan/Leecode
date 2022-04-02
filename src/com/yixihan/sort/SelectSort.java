package com.yixihan.sort;

/**
 * 选择排序
 * <p>
 * <ul>1. 选择排序一共有数组大小 - 1 次轮循环</ul>
 * <ul>2. 每一轮循环, 又是一论循环, 循环的规则(代码) 如下
 *      <ul>先假定当前这个数是最小数</ul>
 *      <ul>然后和后面的每个数进行比较, 如果发现有比当前数更小的数, 就重新确定最小数, 并得到下标</ul>
 *      <ul>当遍历到数组的最后时, 就得到本轮最小数和下标</ul>
 * </ul>
 * <ul>3. 交换</ul>
 *
 * @author : yixihan
 * @create : 2022-03-24-10:55
 */
public class SelectSort {

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minVal = arr[i];
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (minVal > arr[j]) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }

            arr[minIndex] = arr[i];
            arr[i] = minVal;
        }
    }
}

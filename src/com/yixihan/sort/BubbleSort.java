package com.yixihan.sort;

/**
 * 冒泡排序
 * <p>
 * 冒泡排序规则
 * <ul>1. 一共进行数组的大小 -1 次大的循环</ul>
 * <ul>2. 每一趟排序的次数在逐渐的减少</ul>
 * <ul>3. 如果我们发现在某趟排序中, 没有发生一次交换, 可以提前结束冒泡排序, 这个就是优化</ul>
 *
 * @author : yixihan
 * @create : 2022-03-24-10:52
 */
public class BubbleSort {


    public static void bubbleSort (int[] arr) {
        boolean flag;

        for (int i = 0; i < arr.length; i++) {

            flag = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (! flag) {
                break;
            }
        }
    }
}

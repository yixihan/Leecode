package com.yixihan.sort;

/**
 * 快速排序
 * <p>
 * 快速排序是对冒泡排序的一种改进
 * <p>
 * <span>基本思想 :</span>
 * <ul>通过一趟排序将要排序的数据分割成为独立的两部分, 其中一部分的所有数据都比另一部分的所有数据都要小,
 * 然后再按此方法对这两部分分别进行快速排序, 整个排序过程可以递归进行, 以此达到整个数据变成有序序列</ul>
 *
 * 注 :
 * <span>中间值不能用下标获取, 应在一开始就直接获取</span>
 * @author : yixihan
 * @create : 2022-03-24-11:02
 */
public class QuickSort {

    public static void quickSort (int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int midVal = arr[(left + right) / 2];

        // while 循环的目的, 是让比 arr[m] 值小的放到它的左边, 比 arr[m] 值大的放到它的右边
        while (l < r) {
            while (arr[l] < midVal) {
                l++;
            }

            while (arr[r] > midVal) {
                r--;
            }

            // 循环结束条件
            if (l >= r) {
                break;
            }

            // 交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后, 发现 arr[l] == arr[m] 值, 则让 r--, 前移一步
            if (arr[l] == midVal) {
                r--;
            }

            // 如果交换完后, 发现 arr[r] == arr[m] 值, 则让 l++, 后移一步
            if (arr[r] == midVal) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort (arr, left, r);
        }

        if (l < right) {
            quickSort (arr, l, right);
        }


    }
}

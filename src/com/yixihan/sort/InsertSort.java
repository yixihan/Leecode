package com.yixihan.sort;

/**
 * 插入排序
 * <ul>属于内部排序法, 是对于欲排序的元素以插入的方式找寻该元素的适当位置, 以达到排序的目的</ul>
 *
 * <span>基本思想 :</span>
 * <ul>把 n 个待排序的元素看成为一个有序表和无序表, 开始时有序表中只包含一个元素, 无序表中包含有 n - 1 个函数
 * 排序过程中每次从无序表中取出第一个元素, 把它的排序码依次与有序表的排序码进行比较, 将它插入到有序表的适当位置
 * 使之成为新的有序表</ul>
 *
 * @author : yixihan
 * @create : 2022-03-24-11:19
 */
public class InsertSort {

    public static void insertSort (int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}

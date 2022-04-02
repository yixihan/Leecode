package com.yixihan.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : yixihan
 * @create : 2022-03-24-11:00
 */
public class SortTest {

    int[] arr = {2, 43, 5, 6, 78, 6, 4, 3, 5, 7, 8, 4, 23, 1, 53, 4, 86, 3, 231, 57, 568, 2435, 1, 5, 7, 35, 2, 68, 35, 23635, 87, 3};

    @Test
    public void testBubbleSort () {
        System.out.println ("冒泡排序");
        System.out.println ("排序之前 : " + Arrays.toString (arr));
        BubbleSort.bubbleSort (arr);
        System.out.println ("排序之后 : " + Arrays.toString (arr));
    }

    @Test
    public void testSelectSort () {
        System.out.println ("选择排序");
        System.out.println ("排序之前 : " + Arrays.toString (arr));
        SelectSort.selectSort (arr);
        System.out.println ("排序之后 : " + Arrays.toString (arr));
    }

    @Test
    public void testQuickSort () {
        System.out.println ("选择排序");
        System.out.println ("排序之前 : " + Arrays.toString (arr));
        QuickSort.quickSort (arr, 0, arr.length - 1);
        System.out.println ("排序之后 : " + Arrays.toString (arr));
    }

    @Test
    public void testInsertSort () {
        System.out.println ("选择排序");
        System.out.println ("排序之前 : " + Arrays.toString (arr));
        InsertSort.insertSort (arr);
        System.out.println ("排序之后 : " + Arrays.toString (arr));
    }
}

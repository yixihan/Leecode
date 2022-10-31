package com.yixihan.sunday.four;

/**
 * @author yixihan
 * @date 2022-10-31-10:14
 */
public class BFUtils {

    public static int strStr(String str1, String str2) {
        int index = 0;
        int i = 0, j = 0;
        char[] arr1 = str1.toCharArray ();
        char[] arr2 = str2.toCharArray ();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else {
                index++;
                i = index;
                j = 0;
            }
        }
        if (j == arr2.length) {
            return index + 1;//输出的是位置，所以角标要加1！
        }
        return -1;
    }
}

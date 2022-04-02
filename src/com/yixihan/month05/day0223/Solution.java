package com.yixihan.month05.day0223;

import java.util.List;

/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 *
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * @author : yixihan
 * @create : 2022-02-23-12:43
 */
public class Solution {

    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray ();
        int left = 0;
        int right = s.length () - 1;

        while (left < right) {

            if (((arr[right] >= 'a' && arr[right] <= 'z') || (arr[right] >= 'A' && arr[right] <= 'Z')) &&
                    ((arr[left] >= 'a' && arr[left] <= 'z') || (arr[left] >= 'A' && arr[left] <= 'Z'))) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            } else if ((arr[right] < 'a' || arr[right] > 'z') && (arr[right] < 'A' || arr[right] > 'Z')) {
                right--;
            } else if ((arr[left] < 'a' || arr[left] > 'z') && (arr[left] < 'A' || arr[left] > 'Z')) {
                left++;
            }

        }

        return new String (arr);
    }
}

package com.yixihan.month12.day1002;

/**
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 *
 * @author yixihan
 * @date 2022-10-02-9:46
 */
public class Solution {

    public boolean canTransform(String start, String end) {
        char[] arr1 = start.toCharArray ();
        char[] arr2 = end.toCharArray ();
        int n = start.length ();
        int i = 0;
        int j = 0;
        while (true) {
            while (i < n && arr1[i] == 'X') {
                i++;
            }
            while (j < n && arr2[j] == 'X') {
                j++;
            }
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n || arr1[i] != arr2[j]) {
                return false;
            }
            if (arr1[i] == 'L' && i < j || arr2[j] == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }

    }
}

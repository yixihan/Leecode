package com.yixihan.month07.day0513;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * @author : yixihan
 * @create : 2022-05-13-9:12
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {

        char[] arr1 = first.toCharArray ();
        char[] arr2 = second.toCharArray ();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int index1 = 0;
        int index2 = 0;
        int count = 0;

        if (Math.abs (n1 - n2) > 1) {
            return false;
        } else if (n1 == n2 && n1 == 1) {
            return true;
        }

        while (index1 < n1 && index2 < n2) {
            if (arr1[index1] == arr2[index2]) {
                index1++;
                index2++;
                continue;
            } else {
                if (index1 < n1 - 1 && arr1[index1 + 1] == arr2[index2]) {
                    index1++;
                    count++;
                } else if (index2 < n2 - 1 && arr1[index1] == arr2[index2 + 1]) {
                    index2++;
                    count++;
                } else {
                    index1++;
                    index2++;
                    count++;
                }
            }

            if (count > 1) {
                return false;
            }
        }

        return (n1 - index1) + (n2 - index2) + count <= 1;
    }

    static class Main {
        public static void main(String[] args) {
            System.out.println (new Solution ().oneEditAway ("teached", "teacher"));
        }
    }


}

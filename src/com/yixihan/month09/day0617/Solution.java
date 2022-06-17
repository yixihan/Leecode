package com.yixihan.month09.day0617;

import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 * @author : yixihan
 * @create : 2022-06-17-9:13
 */
public class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] tmp = new int[n];
        int index = 0;

        for (int val : arr) {
            if (val == 0) {
                index += 2;
                System.out.println (111);
            } else {
                tmp[index++] = val;
            }
            if (index >= n) {
                break;
            }
        }
        System.out.println (Arrays.toString (tmp));
        System.arraycopy (tmp, 0, arr, 0, n);
    }
}

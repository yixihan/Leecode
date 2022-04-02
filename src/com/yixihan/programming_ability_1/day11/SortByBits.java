package com.yixihan.programming_ability_1.day11;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *
 * @author : yixihan
 * @create : 2022-03-21-10:54
 */
public class SortByBits {
    public int[] sortByBits(int[] arr) {
        // 方式一 : 转为 String 后处理
        //        String[] str = new String[arr.length];
        //        int index = 0;
        //        for (int val : arr) {
        //            str[index++] = Integer.toString (val, 2);
        //        }
        //
        //        Arrays.sort (str, (o1, o2) -> {
        //            if (getOneSum (o1) - getOneSum (o2) == 0) {
        //                return Integer.parseInt (o1, 2) - Integer.parseInt (o2, 2);
        //            } else {
        //                return getOneSum (o1) - getOneSum (o2);
        //            }
        //        });
        //        index = 0;
        //        for (String val : str) {
        //            arr[index++] = Integer.parseInt (val, 2);
        //        }
        //
        //        return arr;

        // 方法二 : 转为 Integer 后处理
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort (nums, (o1, o2) -> {
            int bitCountA = Integer.bitCount (o1);
            int bitCountB = Integer.bitCount (o2);
            // 相同按原数，不同按位数
            return bitCountA == bitCountB ? o1 - o2 : bitCountA - bitCountB;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }

    private int getOneSum(String str) {
        int count = 0;

        for (char c : str.toCharArray ()) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }
}

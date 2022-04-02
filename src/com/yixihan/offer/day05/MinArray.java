package com.yixihan.offer.day05;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-02-25-13:48
 */
public class MinArray {

    public int minArray(int[] numbers) {
        // 方式一 : stream.min ()
//        return Arrays.stream (numbers).min ().getAsInt ();

        // 方式二
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }

        return numbers[0];
    }
}

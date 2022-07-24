package com.yixihan.random.day0724;

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * <p>
 * 完成所有替换操作后，请你返回这个数组。
 * <p>
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * 解释：
 * - 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
 * - 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
 * - 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
 * - 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
 * <p>
 * 输入：arr = [400]
 * 输出：[-1]
 * 解释：下标 0 的元素右侧没有其他元素。
 *
 * @author : yixihan
 * @create : 2022-07-24-8:54
 */
public class ReplaceElements {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] maxNum = new int[len + 1];
        maxNum[0] = 0;
        maxNum[len] = -1;

        for (int i = len - 1; i > 0; i--) {
            maxNum[i] = Math.max (maxNum[i + 1], arr[i]);
        }

        System.arraycopy (maxNum, 1, arr, 0, len);

        return arr;
    }
}

package com.yixihan.random.day0707;

/**
 * 给你一个整数 num ，请你返回三个连续的整数，它们的 和 为 num 。如果 num 无法被表示成三个连续整数的和，请你返回一个 空 数组。
 * <p>
 * 输入：num = 33
 * 输出：[10,11,12]
 * 解释：33 可以表示为 10 + 11 + 12 = 33 。
 * 10, 11, 12 是 3 个连续整数，所以返回 [10, 11, 12] 。
 * <p>
 * 输入：num = 4
 * 输出：[]
 * 解释：没有办法将 4 表示成 3 个连续整数的和。
 *
 * @author : yixihan
 * @create : 2022-07-07-13:35
 */
public class SumOfThree {

    public long[] sumOfThree(long num) {
        long[] ans = new long[]{};
        long mid = (num - 3) / 3;

        for (int i = 0; i < 3; i++) {
            if (3 * mid == num) {
                ans = new long[]{mid - 1, mid, mid + 1};
                break;
            } else {
                mid++;
            }
        }

        return ans;
    }
}

package com.yixihan.month12.day0926;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * <p>
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 输入: [1]
 * 输出: [2,3]
 * <p>
 * 输入: [2,3]
 * 输出: [1,4]
 *
 * @author : yixihan
 * @date : 2022-09-26-9:13
 */
public class Solution {

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;
        for (int i : nums) sum += i;
        // 两个缺失元素之和
        int ts = (1 + n) * n / 2 - sum;
        // 两个元素之间的 "分界" (一个缺失元素大于这个值, 另一个小于这个值)
        int m = ts / 2;

        // 将问题转换为求一个缺失元素
        sum = 0;
        for (int i : nums) {
            if (i <= m) {
                sum += i;
            }
        }
        int res = (1 + m) * m / 2 - sum;
        return new int[]{res, ts - res};
    }
}

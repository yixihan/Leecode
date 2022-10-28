package com.yixihan.month13.day1028;

import java.util.ArrayDeque;

/**
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 *
 * @author yixihan
 * @date 2022-10-28-9:04
 */
public class Solution {
    final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        ArrayDeque<int[]> stack = new ArrayDeque<> ();
        int ans = 0, sum = 0;
        for (int x : arr) {
            int c = 1;
            while (!stack.isEmpty () && stack.peek ()[0] >= x) {
                int[] cur = stack.pop ();
                c += cur[1];
                sum -= cur[0] * cur[1];
            }
            stack.push (new int[]{x, c});
            sum += x * c;
            ans += sum;
            ans %= MOD;
        }
        return ans;
    }
}

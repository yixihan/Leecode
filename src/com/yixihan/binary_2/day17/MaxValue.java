package com.yixihan.binary_2.day17;

/**
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 * <p>
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 * <p>
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 * <p>
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 * <p>
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-05-25-9:02
 */
public class MaxValue {

    public int maxValue(int n, int index, int maxSum) {
        long left = 1;
        long right = maxSum;

        while (left < right) {
            long mid = (left + right) >> 1;
            if (verify (n, index, maxSum, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }

            if (left == right - 1) {
                if (verify (n, index, maxSum, right)) {
                    left = right;
                }
                break;
            }
        }
        return (int) left;
    }

    private boolean verify(int n, int index, int maxSum, long max) {
        long sum = 0;

        if (index < max - 1) {
            sum += (2 * max - index) * (index + 1) / 2;
        } else {
            sum += max * (max + 1) / 2 + index - max + 1;
        }

        if (max + index <= n) {
            sum += max * (max + 1) / 2 + n - max - index;
        } else {
            sum += (2 * max + index - n + 1) * (n - index) / 2;
        }

        sum -= max;
        return sum <= maxSum;
    }
}

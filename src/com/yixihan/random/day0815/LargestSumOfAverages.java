package com.yixihan.random.day0815;

/**
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
 * <p>
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * <p>
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 * <p>
 * 输入: nums = [9,1,2,3,9], k = 3
 * 输出: 20.00000
 * 解释:
 * nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 nums 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 4
 * 输出: 20.50000
 *
 * @author : yixihan
 * @create : 2022-08-15-9:03
 */
public class LargestSumOfAverages {

    /**
     * dp[i][k]表示前i个数构成k个子数组时的最大平均值, 那么对于所有 0 <= j <= i-1
     * dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (A[j+1] + ... + A[i+1]) / (i-j))
     */
    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        double[][] dp = new double[len + 1][k + 1];
        double[] sum = new double[len + 1];

        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            dp[i][1] = sum[i] / i;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 2; j <= k; j++) {
                for (int y = 0; y < i; y++) {
                    dp[i][j] = Math.max (dp[i][j], dp[y][j - 1] + (sum[i] - sum[y]) / (i - y));
                }
            }
        }

        return dp[len][k];
    }
}

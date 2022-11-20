package com.yixihan.month14.day1121;

/**
 * 有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的 汤A 和 0ml 的 汤B 。
 * 提供 75ml 的 汤A 和 25ml 的 汤B 。
 * 提供 50ml 的 汤A 和 50ml 的 汤B 。
 * 提供 25ml 的 汤A 和 75ml 的 汤B 。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。
 * 如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 * <p>
 * 注意 不存在先分配 100 ml 汤B 的操作。
 * <p>
 * 需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
 * <p>
 * 输入: n = 50
 * 输出: 0.62500
 * 解释:如果我们选择前两个操作，A 首先将变为空。
 * 对于第三个操作，A 和 B 会同时变为空。
 * 对于第四个操作，B 首先将变为空。
 * 所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 * <p>
 * 输入: n = 100
 * 输出: 0.71875
 *
 * @author yixihan
 * @date 2022/11/21 0:44
 */
public class Solution {
    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }
        n = (int) Math.ceil (n / 25.0);
        double[][] dp = new double[n + 1][n + 1];
        //特殊条件
        dp[0][0] = 0.5;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            int a1 = Math.max (i - 4, 0);
            int a2 = Math.max (i - 3, 0);
            int a3 = Math.max (i - 2, 0);
            int a4 = Math.max (i - 1, 0);
            for (int j = 1; j < n + 1; j++) {
                int b1 = j;
                int b2 = Math.max (j - 1, 0);
                int b3 = Math.max (j - 2, 0);
                int b4 = Math.max (j - 3, 0);
                dp[i][j] = 0.25 * (dp[a1][b1] + dp[a2][b2] + dp[a3][b3] + dp[a4][b4]);
            }
        }
        return dp[n][n];
    }
}

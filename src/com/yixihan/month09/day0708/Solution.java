package com.yixihan.month09.day0708;

/**
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * <p>
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * <p>
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * 输入：position = [1,2,3]
 * 输出：1
 * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
 * 第二步:将位置2的筹码移动到位置1，成本= 1。
 * 总成本是1。
 * <p>
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 * <p>
 * 输入：position = [1,1000000000]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-07-08-7:10
 */
public class Solution {

    /**
     * 移动两个位置不需要代价, 故只需统计奇数和偶数个数, 然后取最小值即可
     *
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int oddNum = 0;
        int evenNum = 0;

        for (int j : position) {
            if ((j & 1) == 0) {
                evenNum++;
            } else {
                oddNum++;
            }
        }

        return Math.min (oddNum, evenNum);
    }
}

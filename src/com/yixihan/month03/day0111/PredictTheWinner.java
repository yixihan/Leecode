package com.yixihan.month03.day0111;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
 *
 * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。
 * 每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。
 * 玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
 *
 * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。
 * 你可以假设每个玩家的玩法都会使他的分数最大化。

 *
 * 输入：nums = [1,5,2]
 * 输出：false
 * 解释：一开始，玩家 1 可以从 1 和 2 中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 false 。
 *
 * 输入：nums = [1,5,233,7]
 * 输出：true
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 true，表示玩家 1 可以成为赢家。
 *
 * @author : yixihan
 * @create : 2022-01-11-8:10
 */
public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {

        // 对于偶数个数字的数组，玩家1一定获胜。
        // 因为如果玩家1选择拿法A，玩家2选择拿法B，玩家1输了。则玩家1换一种拿法选择拿法B，因为玩家1是先手，所以玩家1一定可以获胜。
        if (nums.length % 2 == 0) {
            return true;
        }

        int len = nums.length;

        int[][] dp = new int[len][len];

        for (int k = 0; k < len; k++) {
            for (int i = 0, j = i + k; j < len; i++, j++) {

                if (k == 0) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max (nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1] >= 0;
    }
}

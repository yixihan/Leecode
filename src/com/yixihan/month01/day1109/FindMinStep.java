package com.yixihan.month01.day1109;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 你正在参与祖玛游戏的一个变种。
 *
 * 在这个祖玛游戏变体中,桌面上有 一排 彩球,每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 *
 * 你的目标是 清空 桌面上所有的球。每一回合：
 *
 * 从你手上的彩球中选出 任意一颗 ,然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
 * 接着,如果有出现 三个或者三个以上 且 颜色相同 的球相连的话,就把它们移除掉。
 * 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连,则可以继续移除这些球,直到不再满足移除条件。
 * 如果桌面上所有球都被移除,则认为你赢得本场游戏。
 * 重复这个过程,直到你赢了游戏或者手中没有更多的球。
 * 给你一个字符串 board ,表示桌面上最开始的那排球。另给你一个字符串 hand ,表示手里的彩球。请你按上述操作步骤移除掉桌上所有球,计算并返回所需的 最少 球数。如果不能移除桌上所有的球,返回 -1 。
 *
 * 输入：board = "WRRBBW", hand = "RB"
 * 输出：-1
 * 解释：无法移除桌面上的所有球。可以得到的最好局面是：
 * - 插入一个 'R' ,使桌面变为 WRRRBBW 。WRRRBBW -> WBBW
 * - 插入一个 'B' ,使桌面变为 WBBBW 。WBBBW -> WW
 * 桌面上还剩着球,没有其他球可以插入。
 *
 * 输入：board = "WWRRBBWW", hand = "WRBRW"
 * 输出：2
 * 解释：要想清空桌面上的球,可以按下述步骤：
 * - 插入一个 'R' ,使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
 * - 插入一个 'B' ,使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 *
 * 输入：board = "G", hand = "GGGGG"
 * 输出：2
 * 解释：要想清空桌面上的球,可以按下述步骤：
 * - 插入一个 'G' ,使桌面变为 GG 。
 * - 插入一个 'G' ,使桌面变为 GGG 。GGG -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 *
 * 输入：board = "RBYYBBRRB", hand = "YRBGB"
 * 输出：3
 * 解释：要想清空桌面上的球,可以按下述步骤：
 * - 插入一个 'Y' ,使桌面变为 RBYYYBBRRB 。RBYYYBBRRB -> RBBBRRB -> RRRB -> B
 * - 插入一个 'B' ,使桌面变为 BB 。
 * - 插入一个 'B' ,使桌面变为 BBB 。BBB -> empty
 * 只需从手中出 3 个球就可以清空桌面。
 *
 *
 * @author : yixihan
 * @create : 2021-11-09-20:01
 */
public class FindMinStep {

    /**
     * 手中最多只有 5 个球, 所以, 操作次数不会多于 5
     */
    int INF = 6;


    /**
     * 暴力 dfs
     */
    public int findMinStep(String board, String hand) {
        // 记忆化缓存
        Map<String, Integer> memo = new HashMap<>();
        // 递归开始
        int ans = dfs(board, hand.toCharArray(), memo);
        // 判断结果
        return ans >= INF ? -1 : ans;
    }

    private int dfs(String board, char[] hand, Map<String, Integer> memo) {
        // 如果 board 全部消除完了, 直接返回
        if (board.length() == 0) {
            return 0;
        }

        // 如果缓存中已经处理过了, 直接返回
        if (memo.containsKey(board)) {
            return memo.get(board);
        }

        // 存储本次递归的结果
        int ans = INF;

        // 将手中的球填序的 board 的任意位置尝试去消除
        for (int i = 0; i < hand.length; i++) {
            char c = hand[i];
            if (c != '0') {
                for (int j = 0; j < board.length(); j++) {
                    // 构造新的 board, 插入到旧 board 的任意位置
                    StringBuilder newBoard = new StringBuilder()
                            .append(board, 0, j)
                            .append(c)
                            .append(board.substring(j));

                    // 尝试消除
                    removeSame(newBoard, j);
                    // 表示这个球已经用过了
                    hand[i] = '0';
                    // 进入下一次递归
                    ans = Math.min(ans, dfs(newBoard.toString(), hand, memo) + 1);
                    // 回溯, 恢复状态
                    hand[i] = c;
                }
            }
        }

        // 记录到缓存中
        memo.put(board, ans);
        // 返回结果
        return ans;
    }

    private void removeSame(StringBuilder board, int index) {
        // 移除三个以上连续的
        if (index < 0 ) {
            return;
        }
        // 从 index 的位置向两边扩散
        int left = index, right = index;
        char c = board.charAt(index);
        // 将 left 和 right 移动到字符不相等的位置
        while (--left >= 0 && board.charAt(left) == c) ;
        while (++right < board.length() && board.charAt(right) == c) ;

        // 扩散完了两边的 right 和 left 位置的值都是不等于 c 的,需要减一表示 c 出现的次数
        int count = right - left - 1;
        // 大于等于 3 才消除
        if (count >= 3) {
            board.delete(left + 1, right);
            // 连锁反应, 比如 YYGGGY, 移除了中间的 G, 三个Y挨一块了, 也要移除
            removeSame(board, left);
        }
    }

    @Test
    public void test () {
        // board = "RBYYBBRRB", hand = "YRBGB"
        System.out.println(findMinStep("RBYYBBRRB", "YRBGB"));
    }

}

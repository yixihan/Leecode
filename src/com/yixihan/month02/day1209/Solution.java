package com.yixihan.month02.day1209;

/**
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 *
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 *
 * 输入：board = ["O  ","   ","   "]
 * 输出：false
 * 解释：玩家 1 总是放字符 "X" 。
 *
 * 输入：board = ["XOX"," X ","   "]
 * 输出：false
 * 解释：玩家应该轮流放字符。
 *
 * @author : yixihan
 * @create : 2021-12-09-15:32
 */
public class Solution {

    /**
     * 1. X必须比O多1个或者相同，否则false；
     * 2. X和O不能同时都是赢家，否则false；
     * 3. X赢的时候必须比O多1个，否则false；
     * 4. O赢得时候个数与X相同，否则false；
     */
    public boolean validTicTacToe(String[] board) {

        // 1
        if (!countDiff (board)) {
            return false;
        }

        // 2
        if (isWinner (board, 'X') && isWinner (board, 'O')) {
            return false;
        }

        // 3
        if (isWinner (board, 'X') && charCount (board, 'X') - charCount (board, 'O') != 1) {
            return false;
        }

        // 4
        return !isWinner (board, 'O') || charCount (board, 'X') == charCount (board, 'O');
    }

    public int charCount(String[] board, char c) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (char ch : board[i].toCharArray ()) {
                if (c == ch) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 判断是不是c（X或者O）赢了,X赢得时候，X比O多1，反之相同
     */
    public boolean isWinner(String[] board, char c) {
        if (board[0].charAt (0) == board[1].charAt (1) && board[1].charAt (1) == board[2].charAt (2) && board[2].charAt (2) == c) {
            return true;
        }
        if (board[0].charAt (2) == board[1].charAt (1) && board[1].charAt (1) == board[2].charAt (0) && board[2].charAt (0) == c) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt (0) == board[i].charAt (1) && board[i].charAt (1) == board[i].charAt (2) && board[i].charAt (2) == c) {
                return true;
            }
            if (board[0].charAt (i) == board[1].charAt (i) && board[1].charAt (i) == board[2].charAt (i) && board[2].charAt (i) == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断X是不是比O多1或者相同
     */
    public boolean countDiff(String[] board) {

        int xNum = 0;
        int oNum = 0;
        for (int i = 0; i < 3; i++) {
            for (char c : board[i].toCharArray ()) {
                if (c == 'X') {
                    xNum++;
                }
                if (c == 'O') {
                    oNum++;
                }
            }
        }
        return xNum - oNum == 0 || xNum - oNum == 1;
    }
}

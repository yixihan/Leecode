package com.yixihan.random.day0716;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-07-16-8:10
 */
public class Exist {

    char[][] board;
    boolean[][] visited;
    char[] letter;

    public boolean exist(char[][] board, String word) {
        letter = word.toCharArray ();
        this.board = board;
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = helper (0, i, j);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(int index, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;

        if (board[x][y] == letter[index]) {
            if (index == letter.length - 1) {
                return true;
            }
            boolean flag = helper (index + 1, x + 1, y)
                    || helper (index + 1, x, y + 1)
                    || helper (index + 1, x, y - 1)
                    || helper (index + 1, x - 1, y);

            if (flag) {
                return true;
            } else {
                visited[x][y] = false;
                return false;
            }
        } else {
            visited[x][y] = false;
            return false;
        }
    }
}

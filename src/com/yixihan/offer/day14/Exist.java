package com.yixihan.offer.day14;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-03-06-13:28
 */
public class Exist {
    boolean[][] visited;
    int m;
    int n;
    char[] arr;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        arr = word.toCharArray ();
        visited = new boolean[m][n];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs (board, i, j, index)) {
                    return true;
                }

            }
        }

        return false;
    }

    private boolean dfs (char[][] board, int i, int j, int index) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != arr[index] || visited[i][j]) {
            return false;
        }
        if (index == arr.length - 1) {
            return true;
        }

        visited[i][j] = true;

        boolean ans = false;
        ans = dfs(board, i + 1, j, index + 1) || dfs(board, i - 1, j, index + 1)
                || dfs(board, i, j + 1, index + 1) || dfs(board, i, j - 1, index + 1);
        visited[i][j] = false;
        return ans;

    }

}

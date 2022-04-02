package com.yixihan.data_structure_1.day5;

import java.util.HashSet;
import java.util.Set;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 *
 * 输入：board = 
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 * 输入：board = 
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *
 * @author : yixihan
 * @create : 2022-03-14-12:53
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 暴力解之一行解决 (泪)
//        return judgeCol (board) && judgeRow (board) && judgeBlock(board);

        // 方法二 :
        // 记录行
        boolean[][] row = new boolean[9][9];
        // 记录列
        boolean[][] col = new boolean[9][9];
        // 记录小块
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = (i / 3) * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }

        return true;
    }

    private boolean judgeCol (char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && ! set.contains (board[i][j])) {
                    set.add (board[i][j]);
                } else if (board[i][j] != '.' && set.contains (board[i][j])) {
                    return false;
                }
            }
            set.clear ();
        }
        return true;
    }


    private boolean judgeRow (char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && ! set.contains (board[i][j])) {
                    set.add (board[i][j]);
                } else if (board[i][j] != '.' && set.contains (board[i][j])) {
                    return false;
                }
            }
            set.clear ();
        }
        return true;
    }

    private boolean judgeBlock (char[][] board) {
        int count = 0;
        Set<Character> set = new HashSet<>();

        while (count < 9) {

            for (int i = (count / 3) * 3; i < (count / 3) * 3 + 3; i++) {
                for (int j = (count % 3) * 3; j < (count % 3) * 3 + 3; j++) {
                    if (board[i][j] != '.' && ! set.contains (board[i][j])) {
                        set.add (board[i][j]);
                    } else if (board[i][j] != '.' && set.contains (board[i][j])) {
                        return false;
                    }
                }
            }
            set.clear ();
            count++;
        }
        return true;
    }
}

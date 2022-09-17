package com.yixihan.random.day0917;

/**
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * <p>
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 *
 * @author : yixihan
 * @create : 2022-09-17-9:25
 */
public class IsToeplitzMatrix {

    int m;
    int n;
    boolean[][] visited;
    int[][] matrix;

    public boolean isToeplitzMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        this.matrix = matrix;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (!helper (i, j, matrix[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean helper(int x, int y, int val) {
        if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
            visited[x][y] = true;
            if (matrix[x][y] != val) {
                return false;
            }
            return helper (x - 1, y - 1, val) || helper (x + 1, y + 1, val);
        } else {
            if (x >= 0 && x < m && y >= 0 && y < n && visited[x][y]) {
                return true;
            } else return x < 0 || x >= m || y < 0 || y >= n;
        }
    }
}

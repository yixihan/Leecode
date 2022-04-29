package com.yixihan.month07.day0429;

/**
 * @author : yixihan
 * @create : 2022-04-29-10:12
 */
public class Solution {

    int[][] preSum;
    int[][] grid;
    int n;

    public Node construct(int[][] grid) {
        this.n = grid.length;
        this.preSum = new int[n + 1][n + 1];
        this.grid = grid;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                preSum[r + 1][c + 1] = preSum[r + 1][c] + preSum[r][c + 1] - preSum[r][c] + grid[r][c];
            }
        }
        return construct (0, 0, n - 1, n - 1);
    }

    public Node construct(int topLeftRow, int topLeftCol, int bottomRightRow, int bottomRightCol) {
        int len = bottomRightRow - topLeftRow + 1;
        int sum = preSum[bottomRightRow + 1][bottomRightCol + 1] + preSum[topLeftRow][topLeftCol] -
                preSum[bottomRightRow + 1][topLeftCol] - preSum[topLeftRow][bottomRightCol + 1];
        if (sum == 0 || sum == len * len) {
            return new Node (sum == len * len, true);
        }

        Node res = new Node ();
        res.topLeft = construct (topLeftRow, topLeftCol, topLeftRow + len / 2 - 1, topLeftCol + len / 2 - 1);
        res.topRight = construct (topLeftRow, topLeftCol + len / 2, topLeftRow + len / 2 - 1, bottomRightCol);
        res.bottomLeft = construct (topLeftRow + len / 2, topLeftCol, bottomRightRow, topLeftCol + len / 2 - 1);
        res.bottomRight = construct (topLeftRow + len / 2, topLeftCol + len / 2, bottomRightRow, bottomRightCol);
        return res;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;
}

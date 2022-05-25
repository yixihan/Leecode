package com.yixihan.binary_2.day17;

/**
 * 一个 2D 网格中的 顶峰元素 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * <p>
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。
 * 找出 任意一个 顶峰元素 mat[i][j] 并 返回其位置 [i,j] 。
 * <p>
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * <p>
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 * <p>
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3和4都是顶峰元素，所以[1,0]和[0,1]都是可接受的答案。
 * <p>
 * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * 输出: [1,1]
 * 解释: 30和32都是顶峰元素，所以[1,1]和[2,2]都是可接受的答案。
 *
 * @author : yixihan
 * @create : 2022-05-25-8:40
 */
public class FindPeakGrid {

    int[][] mat;
    int m;
    int n;

    public int[] findPeakGrid(int[][] mat) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        int x = 0;
        int y = 0;

        while (x < m && y < n) {
            // System.out.println (x + ", " + y);
            if (verifyPeakGrid (x, y)) {
                return new int[]{x, y};
            }

            int[] tmp = getBiggerPoint (x, y);
            x = tmp[0];
            y = tmp[1];
        }

        return new int[]{x, y};
    }

    private boolean verifyPeakGrid(int x, int y) {
        if (x > 0 && mat[x][y] < mat[x - 1][y]) {
            return false;
        }

        if (x < m - 1 && mat[x][y] < mat[x + 1][y]) {
            return false;
        }

        if (y > 0 && mat[x][y] < mat[x][y - 1]) {
            return false;
        }

        if (y < n - 1 && mat[x][y] < mat[x][y + 1]) {
            return false;
        }

        return true;
    }

    private int[] getBiggerPoint(int x, int y) {
        int maxValue = mat[x][y];
        int[] maxIndex = new int[2];

        if (x > 0 && maxValue < mat[x - 1][y]) {
            maxValue = mat[x - 1][y];
            maxIndex = new int[]{x - 1, y};
        }

        if (x < m - 1 && maxValue < mat[x + 1][y]) {
            maxValue = mat[x + 1][y];
            maxIndex = new int[]{x + 1, y};
        }

        if (y > 0 && maxValue < mat[x][y - 1]) {
            maxValue = mat[x][y - 1];
            maxIndex = new int[]{x, y - 1};
        }

        if (y < n - 1 && maxValue < mat[x][y + 1]) {
            maxIndex = new int[]{x, y + 1};
        }

        return maxIndex;
    }
}

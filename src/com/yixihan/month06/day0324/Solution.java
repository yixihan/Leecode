package com.yixihan.month06.day0324;

/**
 * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * <p>
 * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。
 * （即，需要计算蓝色平滑器中 9 个单元格的平均值）。
 * <p>
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
 * <p>
 * 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
 * <p>
 * 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * <p>
 * 输入: img = [[100,200,100],[200,50,200],[100,200,100]]
 * 输出: [[137,141,137],[141,138,141],[137,141,137]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * 对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * 对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 *
 * @author : yixihan
 * @create : 2022-03-24-9:36
 */
public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = getAns (img, i, j);
            }
        }

        return ans;
    }

    private int getAns(int[][] img, int i, int j) {
        int sum = img[i][j];
        int count = 1;

        if (i - 1 >= 0) {
            sum += img[i - 1][j];
            count++;
            if (j - 1 >= 0) {
                sum += img[i - 1][j - 1];
                count++;
            }
            if (j + 1 < img[i].length) {
                sum += img[i - 1][j + 1];
                count++;
            }
        }
        if (i + 1 < img.length) {
            sum += img[i + 1][j];
            count++;
            if (j - 1 >= 0) {
                sum += img[i + 1][j - 1];
                count++;
            }
            if (j + 1 < img[i].length) {
                sum += img[i + 1][j + 1];
                count++;
            }
        }
        if (j - 1 >= 0) {
            sum += img[i][j - 1];
            count++;
        }
        if (j + 1 < img[i].length) {
            sum += img[i][j + 1];
            count++;
        }

        return sum / count;
    }
}

package com.yixihan.random.day0805;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个大小为 m x n 的整数矩阵 grid ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。
 * <p>
 * 矩阵由若干层组成，如下图所示，每种颜色代表一层：
 * <p>
 * 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
 * <p>
 * 返回执行 k 次循环轮转操作后的矩阵。
 * <p>
 * 输入：grid = [[40,10],[30,20]], k = 1
 * 输出：[[10,20],[40,30]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 * <p>
 * 输入：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
 * 输出：[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
 * 解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
 *
 * @author : yixihan
 * @create : 2022-08-05-12:27
 */
public class RotateGrid {

    public int[][] rotateGrid(int[][] grid, int k) {
        List<List<Integer>> gridList = new ArrayList<> ();
        int m = grid.length;
        int n = grid[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
//        System.out.println ("left = " + left + ", right = " + right + ", top = " + top + ", bottom = " + bottom);

        while (left < right && top < bottom) {
            List<Integer> list = new ArrayList<> ();
            for (int i = left; i <= right; i++) {
                list.add (grid[top][i]);
            }
            if (top++ >= bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                list.add (grid[i][right]);
            }
            if (right-- < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add (grid[bottom][i]);
            }
            if (bottom-- < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                list.add (grid[i][left]);
            }
            if (left++ > right) {
                break;
            }
            gridList.add (list);
        }

        left = 0;
        right = n - 1;
        top = 0;
        bottom = m - 1;
        for (List<Integer> list : gridList) {
            int tmp = k % list.size ();
            list.addAll (list.subList (0, tmp));
            int index = tmp;
            for (int i = left; i <= right; i++) {
                grid[top][i] = list.get (index++);
            }
            if (top++ >= bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                grid[i][right] = list.get (index++);
            }
            if (right-- < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                grid[bottom][i] = list.get (index++);
            }
            if (bottom-- < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                grid[i][left] = list.get (index++);
            }
            if (left++ > right) {
                break;
            }
        }


        return grid;
    }
}

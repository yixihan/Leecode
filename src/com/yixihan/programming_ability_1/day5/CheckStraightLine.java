package com.yixihan.programming_ability_1.day5;

/**
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上。
 *
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * 
 * @author : yixihan
 * @create : 2022-03-15-11:51
 */
public class CheckStraightLine {

    /**
     * 由斜率公式得
     * (y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
     * 防止除0，变换成相乘的形式
     * (y1-y0)*(xi-x0)==(x1-x0)*(yi-y0)
     */
    public boolean checkStraightLine(int[][] coordinates) {

        for (int i = 2; i < coordinates.length; i++) {

            if ((coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0]) !=
                    (coordinates[1][0] - coordinates[0][0]) * (coordinates[i][1] - coordinates[0][1])) {
                return false;
            }

        }

        return true;
    }
}

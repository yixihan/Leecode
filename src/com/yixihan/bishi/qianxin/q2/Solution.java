package com.yixihan.bishi.qianxin.q2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : yixihan
 * @create : 2022-09-15-19:32
 */
public class Solution {

    int x = 0;
    int y = 0;
    int cnt;
    int minDis = 0;
    int[][] distance;
    boolean[] visited;
    int[][] points;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 得到最短路径长度
     * @param points int整型二维数组 食物位置
     * @return int整型
     */
    public int getMinLen (int[][] points) {
        // write code here
        this.points = points;
        cnt = points.length;
        visited = new boolean[cnt];
        dfs ();

        return minDis;
    }

    private void dfs() {
        while (cnt > 0) {
            updateDis ();
            minDis += distance[0][0];
            x = points[distance[0][1]][0];
            y = points[distance[0][1]][1];
            visited[distance[0][1]] = true;
            cnt--;
        }
    }

    private void updateDis() {
        distance = new int[cnt][2];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (!visited[i]) {
                distance[index][0] = Math.abs (point[0] - x) + Math.abs (point[1] - y);
                distance[index++][1] = i;
            }
        }
        Arrays.sort (distance, Comparator.comparingInt (o -> o[0]));
    }
}

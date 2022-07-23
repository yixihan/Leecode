package com.yixihan.random.day0723;

import java.util.*;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 *
 * @author : yixihan
 * @create : 2022-07-23-12:30
 */
public class PondSizes {

    List<Integer> list = new ArrayList<> ();
    int[][] land;

    public int[] pondSizes(int[][] land) {
        this.land = land;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    int size = dfs (i, j);
                    if (size != 0) {
                        list.add (size);
                    }
                }
            }
        }

        Collections.sort (list);
        int[] ans = new int[list.size ()];
        int index = 0;

        for (int val : list) {
            ans[index++] = val;
        }

        return ans;
    }

    private int dfs(int x, int y) {
        int cnt = 0;
        if (x >= 0 && x < land.length && y >= 0 && y < land[0].length && land[x][y] == 0) {
            cnt++;
            land[x][y] = 1;

            cnt += dfs (x + 1, y) + dfs (x + 1, y + 1) + dfs (x + 1, y - 1) + dfs (x, y + 1) + dfs (x, y - 1) + dfs (x - 1, y)
                    + dfs (x - 1, y + 1) + dfs (x - 1, y - 1);
        }

        return cnt;

    }
}

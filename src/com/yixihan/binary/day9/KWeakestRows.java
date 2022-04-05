package com.yixihan.binary.day9;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 *
 * 输入：mat = 
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]], 
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2 
 * 行 1 -> 4 
 * 行 2 -> 1 
 * 行 3 -> 2 
 * 行 4 -> 5 
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 *
 * 输入：mat = 
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]], 
 * k = 2
 * 输出：[0,2]
 * 解释： 
 * 每行中的军人数目：
 * 行 0 -> 1 
 * 行 1 -> 4 
 * 行 2 -> 1 
 * 行 3 -> 1 
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *
 * @author : yixihan
 * @create : 2022-04-05-14:34
 */
public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<> (m,
                ((o1, o2) -> o1[0] == o2[0] ?
                        Integer.compare (o1[1], o2[1]) :
                        Integer.compare (o1[0], o2[0]))
        );

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (mat[i][mid] == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // System.out.println (left + ", " + right);
            queue.add (new int[]{left, i});
        }

        int index = 0;
        while (index < k && ! queue.isEmpty ()) {
            ans[index++] = queue.poll ()[1];
        }

        return ans;
    }
}

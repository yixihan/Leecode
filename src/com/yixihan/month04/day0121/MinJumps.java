package com.yixihan.month04.day0121;

import java.util.*;

/**
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标：
 *
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 *
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 *
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 *
 * 输入：arr = [6,1,9]
 * 输出：2
 *
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-01-21-6:36
 */
public class MinJumps {

    public static final int MAX = Integer.MAX_VALUE;

    public int minJumps(int[] arr) {

        int n = arr.length;
        Queue<Integer> queue = new LinkedList<> ();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            List<Integer> list = map.getOrDefault (val, new ArrayList<> ());
            list.add (i);
            map.put (val, list);
        }

        // 每个元素到最后一个元素的距离, 用来存储结果
        int[] dis = new int[n];
        Arrays.fill (dis, MAX);
        dis[n - 1] = 0;
        queue.offer (n - 1);
        // 记录每个元素是否被访问过, 初始为 false
        boolean[] visited = new boolean[n];
        while (! queue.isEmpty ()) {
            int x = queue.poll ();

            // x 左边的元素还没有计算过
            if ((x - 1) >= 0 && dis[x - 1] == MAX) {
                dis[x - 1] = dis[x] + 1;
                queue.offer (x - 1);
            }

            if ((x + 1) < n && dis[x + 1] == MAX) {
                dis[x + 1] = dis[x] + 1;
                queue.offer (x +1);
            }

            if (! visited[x]) {
                for (Integer index : map.get (arr[x])) {
                    if (dis[index] == MAX) {
                        dis[index] = dis[x] + 1;
                        queue.offer (index);
                        visited[index] = true;
                    }
                }
            }
        }

        return dis[0];
    }
}

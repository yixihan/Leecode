package com.yixihan.month06.day0406;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * <p>
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。
 * 给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * <p>
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。
 * 在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * <p>
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * <p>
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 * <p>
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * <p>
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 *
 * @author : yixihan
 * @create : 2022-04-06-14:52
 */
public class Solution {

    private int[] e;
    private Queue<Integer> queue;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        boolean[][] graph = new boolean[n][n];
        boolean[] visited = new boolean[n];
        e = new int[n];
        queue = new LinkedList<> ();

        //初始化构建图
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
            e[edge[0]]++;
            e[edge[1]]++;

        }

        //去除最外层的节点
        while (n > 2) {
            //遍历图,找到最外层节点
            findOuter ();
            while (!queue.isEmpty ()) {
                Integer v = queue.poll ();
                e[v]--;
                n--;
                visited[v] = true;
                for (int i = 0; i < graph[v].length; i++) {
                    if (graph[v][i]) {
                        e[i]--;
                        graph[v][i] = false;
                        graph[i][v] = false;
                    }
                }


            }
        }

        List<Integer> rt = new ArrayList<> ();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                rt.add (i);
            }
        }

        return rt;
    }

    public void findOuter() {
        for (int i = 0; i < e.length; i++) {
            if (e[i] == 1) {
                queue.add (i);
            }
        }
    }

}

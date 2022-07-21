package com.yixihan.random.day0721;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 * @author : yixihan
 * @create : 2022-07-21-9:41
 */
public class AllPathsSourceTarget {

    int[][] graph;
    int n;
    List<List<Integer>> ans;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        this.graph = graph;
        ans = new ArrayList<> ();

        ArrayList<Integer> list = new ArrayList<> ();
        list.add (0);
        helper (0, list);

        return ans;
    }

    private void helper(int index, List<Integer> list) {
        if (index == n - 1) {
            ans.add (list);
        }

        for (int i = 0; i < graph[index].length; i++) {
            list.add (graph[index][i]);
            helper (graph[index][i], new ArrayList<> (list));
            list.remove (list.size () - 1);
        }

    }
}

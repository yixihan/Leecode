package com.yixihan.month05.day0218;

import java.util.HashMap;
import java.util.Map;

/**
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 *
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
 *
 * 输入：edges = [[1,2],[2,3],[4,2]]
 * 输出：2
 * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 *
 * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-02-18-8:48
 */
public class FindCenter {
    public int findCenter(int[][] edges) {

        Map<String, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
             map.put (String.valueOf (edge[0]), map.getOrDefault (String.valueOf (edge[0]), 0) + 1);
             map.put (String.valueOf (edge[1]), map.getOrDefault (String.valueOf (edge[1]), 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet ()) {
            if (entry.getValue () == edges.length) {
                return Integer.parseInt (entry.getKey ());
            }
        }

        return 0;

        // 解法二
        // return edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1]?edges[0][0]:edges[0][1];
    }
}

package com.yixihan.data_structure_2.day19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，
 * 其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 * <p>
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 * <p>
 * 你可以以任意顺序返回这些节点编号。
 * <p>
 * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * 输出：[0,3]
 * 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。
 * 从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
 * <p>
 * 输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
 * 输出：[0,2,3]
 * 解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。
 *
 * @author : yixihan
 * @create : 2022-04-11-16:12
 */
public class FindSmallestSetOfVertices {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> in = new HashSet<> ();
        Set<Integer> out = new HashSet<> ();
        List<Integer> ans = new ArrayList<> ();

        for (List<Integer> edge : edges) {
            out.add (edge.get (0));
            in.add (edge.get (1));
        }

        for (Integer i : out) {
            if (!in.contains (i)) {
                ans.add (i);
            }
        }

        return ans;
    }
}

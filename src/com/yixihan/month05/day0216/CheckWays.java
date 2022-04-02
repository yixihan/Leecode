package com.yixihan.month05.day0216;

import java.util.*;

/**
 * 给你一个数组 pairs ，其中 pairs[i] = [xi, yi] ，并且满足：
 * <p>
 * pairs 中没有重复元素
 * xi < yi
 * 令 ways 为满足下面条件的有根树的方案数：
 * <p>
 * 树所包含的所有节点值都在 pairs 中。
 * 一个数对 [xi, yi] 出现在 pairs 中 当且仅当 xi 是 yi 的祖先或者 yi 是 xi 的祖先。
 * 注意：构造出来的树不一定是二叉树。
 * 两棵树被视为不同的方案当存在至少一个节点在两棵树中有不同的父节点。
 * <p>
 * 请你返回：
 * <p>
 * 如果 ways == 0 ，返回 0 。
 * 如果 ways == 1 ，返回 1 。
 * 如果 ways > 1 ，返回 2 。
 * 一棵 有根树 指的是只有一个根节点的树，所有边都是从根往外的方向。
 * <p>
 * 我们称从根到一个节点路径上的任意一个节点（除去节点本身）都是该节点的 祖先 。根节点没有祖先。
 * <p>
 * 输入：pairs = [[1,2],[2,3]]
 * 输出：1
 * 解释：如上图所示，有且只有一个符合规定的有根树。
 * <p>
 * <p>
 * 输入：pairs = [[1,2],[2,3],[1,3]]
 * 输出：2
 * 解释：有多个符合规定的有根树，其中三个如上图所示。
 * <p>
 * 输入：pairs = [[1,2],[2,3],[2,4],[1,5]]
 * 输出：0
 * 解释：没有符合规定的有根树。
 *
 * @author : yixihan
 * @create : 2022-02-16-10:04
 */
public class CheckWays {

    int N = 510;
    int[] cnts = new int[N], fa = new int[N];
    boolean[][] g = new boolean[N][N];

    public int checkWays(int[][] pairs) {

        int m = pairs.length;
        Set<Integer> set = new HashSet<> ();
        int c = 0;
        int ans = 1;

        for (int[] p : pairs) {
            int a = p[0];
            int b = p[1];
            g[a][b] = g[b][a] = true;
            cnts[a]++;
            cnts[b]++;
            set.add (a);
            set.add (b);
        }

        List<Integer> list = new ArrayList<> (set);
        list.sort ((a, b) -> cnts[b] - cnts[a]);

        int n = list.size ();
        int root = list.get (0);

        // 森林
        if (m < n - 1) {
            return 0;
        }

        fa[root] = -1;

        for (int i = 1; i < n; i++) {
            int a = list.get (i);
            boolean ok = false;

            for (int j = i - 1; j >= 0 && !ok; j--) {
                int b = list.get (j);
                if (g[a][b]) {
                    fa[a] = b;
                    ok = true;
                }
            }
            if (!ok) return 0;
        }

        for (int i : set) {
            int j = i;
            while (fa[j] != -1) {
                if (!g[i][fa[j]]) {
                    return 0;
                }
                if (cnts[i] == cnts[fa[j]]) {
                    ans = 2;
                }
                c++;
                j = fa[j];
            }
        }
        return c < m ? 0 : ans;
    }

}

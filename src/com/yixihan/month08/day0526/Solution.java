package com.yixihan.month08.day0526;

import java.util.ArrayList;
import java.util.List;

/**
 * 在二维平面上的 x 轴上，放置着一些方块。
 * <p>
 * 给你一个二维整数数组 positions ，
 * 其中 positions[i] = [lefti, sideLengthi] 表示：第 i 个方块边长为 sideLengthi ，其左侧边与 x 轴上坐标点 lefti 对齐。
 * <p>
 * 每个方块都从一个比目前所有的落地方块更高的高度掉落而下。
 * 方块沿 y 轴负方向下落，直到着陆到 另一个正方形的顶边 或者是 x 轴上 。
 * 一个方块仅仅是擦过另一个方块的左侧边或右侧边不算着陆。一旦着陆，它就会固定在原地，无法移动。
 * <p>
 * 在每个方块掉落后，你必须记录目前所有已经落稳的 方块堆叠的最高高度 。
 * <p>
 * 返回一个整数数组 ans ，其中 ans[i] 表示在第 i 块方块掉落后堆叠的最高高度。
 * <p>
 * 输入：positions = [[1,2],[2,3],[6,1]]
 * 输出：[2,5,5]
 * 解释：
 * 第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 2 。
 * 第 2 个方块掉落后，最高的堆叠由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 第 3 个方块掉落后，最高的堆叠仍然由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 因此，返回 [2, 5, 5] 作为答案。
 * <p>
 * 输入：positions = [[100,100],[200,100]]
 * 输出：[100,100]
 * 解释：
 * 第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 100 。
 * 第 2 个方块掉落后，最高的堆叠可以由方块 1 组成也可以由方块 2 组成，堆叠的最高高度为 100 。
 * 因此，返回 [100, 100] 作为答案。
 * 注意，方块 2 擦过方块 1 的右侧边，但不会算作在方块 1 上着陆。
 *
 * @author : yixihan
 * @create : 2022-05-26-19:22
 */
public class Solution {

    class Node {
        // ls 和 rs 分别代表当前区间的左右子节点所在 tr 数组中的下标
        // val 代表当前区间的最大高度，add 为懒标记
        int ls, rs, val, add;
    }

    int N = (int) 1e9, cnt = 0;
    Node[] tr = new Node[1000010];

    void update(int u, int lc, int rc, int l, int r, int v) {
        if (l <= lc && rc <= r) {
            tr[u].val = v;
            tr[u].add = v;
            return;
        }
        pushdown (u);
        int mid = lc + rc >> 1;
        if (l <= mid) update (tr[u].ls, lc, mid, l, r, v);
        if (r > mid) update (tr[u].rs, mid + 1, rc, l, r, v);
        pushup (u);
    }

    int query(int u, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return tr[u].val;
        pushdown (u);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = query (tr[u].ls, lc, mid, l, r);
        if (r > mid) ans = Math.max (ans, query (tr[u].rs, mid + 1, rc, l, r));
        return ans;
    }

    void pushdown(int u) {
        if (tr[u] == null) tr[u] = new Node ();
        if (tr[u].ls == 0) {
            tr[u].ls = ++cnt;
            tr[tr[u].ls] = new Node ();
        }
        if (tr[u].rs == 0) {
            tr[u].rs = ++cnt;
            tr[tr[u].rs] = new Node ();
        }
        if (tr[u].add == 0) return;
        int add = tr[u].add;
        tr[tr[u].ls].add = add;
        tr[tr[u].rs].add = add;
        tr[tr[u].ls].val = add;
        tr[tr[u].rs].val = add;
        tr[u].add = 0;
    }

    void pushup(int u) {
        tr[u].val = Math.max (tr[tr[u].ls].val, tr[tr[u].rs].val);
    }

    public List<Integer> fallingSquares(int[][] ps) {
        List<Integer> ans = new ArrayList<> ();
        tr[1] = new Node ();
        for (int[] info : ps) {
            int x = info[0], h = info[1], cur = query (1, 1, N, x, x + h - 1);
            update (1, 1, N, x, x + h - 1, cur + h);
            ans.add (tr[1].val);
        }
        return ans;
    }
}

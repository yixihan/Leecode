package com.yixihan.month05.day0308;

/**
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，
 * 它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，
 * 其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。
 * 对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。
 * 如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * <p>
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。
 * 子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * <p>
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 *
 * @author : yixihan
 * @create : 2022-03-08-11:32
 */
public class Solution {
    public int[] platesBetweenCandles(String s, int[][] qs) {
        char[] cs = s.toCharArray ();
        int n = cs.length, m = qs.length;
        int[] l = new int[n], r = new int[n];
        int[] sum = new int[n + 1];

        for (int i = 0, j = n - 1, p = -1, q = -1; i < n; i++, j--) {
            if (cs[i] == '|') p = i;
            if (cs[j] == '|') q = j;
            l[i] = p;
            r[j] = q;
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = qs[i][0], b = qs[i][1];
            int c = r[a], d = l[b];
            if (c != -1 && c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }
}

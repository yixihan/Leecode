package com.yixihan.month07.day0418;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 *
 * 输入：n = 2
 * 输出：[1,2]
 *
 * @author : yixihan
 * @create : 2022-04-18-20:33
 */
public class Solution {

    int count = 0;
    int n;
    List<Integer> list = new ArrayList<> ();

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        dfs (1);
        return list;
    }

    private void dfs(int x) {
        list.add (x);
        count++;
        if (x * 10 <= n) {
            dfs (x * 10);
        }
        if (x + 1 <= n && x / 10 == (x + 1) / 10) {
            dfs (x + 1);
        }
    }
}

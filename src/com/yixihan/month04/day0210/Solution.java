package com.yixihan.month04.day0210;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 *
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 *
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 *
 * 输入：n = 1
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-02-10-11:49
 */
public class Solution {
    public List<String> simplifiedFractions(int n) {

        Set<String> set = new HashSet<> ();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int gcd = gcd(j, i);
                if (gcd == 1) {
                    set.add(i + "/" + j);
                }
            }
        }


        ArrayList<String> list = new ArrayList<> (set);
        list.sort (String::compareTo);
        return list;

    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}

package com.yixihan.month09.day0626;

import java.util.HashMap;

/**
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
 * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 * <p>
 * 输入
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * 输出
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * <p>
 * 解释
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
 * // 0、1、4和6的返回概率必须相等(即概率为1/4)。
 * solution.pick(); // 返回 4
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 6
 * solution.pick(); // 返回 1
 * solution.pick(); // 返回 0
 * solution.pick(); // 返回 4
 *
 * @author : yixihan
 * @create : 2022-06-26-8:28
 */
public class Solution {

    // 合法索引的数量
    int end;
    // 黑名单中元素映射到合法的索引
    HashMap<Integer, Integer> map;

    public Solution(int n, int[] blacklist) {
        end = n - blacklist.length;
        map = new HashMap<Integer, Integer> ();
        int last = n - 1;
        // 初始化映射表
        for (int b : blacklist) {
            map.put (b, 0);
        }
        for (int b : blacklist) {
            // 本身就是无效索引
            if (b >= end) {
                continue;
            }
            // 跳过无效索引
            while (map.containsKey (last)) {
                last--;
            }
            map.put (b, last--);
        }
    }

    public int pick() {
        int index = (int) (Math.random () * end);
        return map.getOrDefault (index, index);
    }
}

package com.yixihan.month03.day1119;

/**
 * 在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足条件 1 和条件 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
 *
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 *
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 *
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 *
 * 输入：n = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 *
 * 输入: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出: 3
 *
 * @author : yixihan
 * @create : 2021-12-19-8:15
 */
public class FindJudge {

    public int findJudge(int n, int[][] trust) {

        boolean[] judge = new boolean[n + 1];
        int[] count = new int[n + 1];

        for (int[] value : trust) {

            // 有多少人相信 value[1]
            count[value[1]]++;

            // value[1] 信任某个人
            judge[value[0]] = true;
        }

        if (n == 1 && trust.length == 0) {
            return 1;
        }

        for (int i = 0; i < n + 1; i++) {

            if (count[i] == n - 1 && !judge[i]) {
                return i;
            }

        }

        return -1;
    }
}

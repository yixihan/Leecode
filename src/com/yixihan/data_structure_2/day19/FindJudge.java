package com.yixihan.data_structure_2.day19;

/**
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。
 * <p>
 * 如果小镇法官真的存在，那么：
 * <p>
 * 小镇法官不会信任任何人。
 * 每个人（除了小镇法官）都信任这位小镇法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * <p>
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 * <p>
 * 输入：n = 2, trust = [[1,2]]
 * 输出：2
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * <p>
 * 输入：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 *
 * @author : yixihan
 * @create : 2022-04-11-15:01
 */
public class FindJudge {
    public int findJudge(int n, int[][] trust) {

        int[] a = new int[n];
        int[] b = new int[n];

        for (int[] ints : trust) {
            a[ints[0] - 1]++;
            b[ints[1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (b[i] == n - 1 && a[i] == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}

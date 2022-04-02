package com.yixihan.month03.day0111;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。
 *
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。
 * 数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 *
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 *
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 *
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 无法向北或者向东移动是因为方格禁止通行。
 * 无法向南或者向西移动是因为不能走出网格。
 *
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 *
 * @author : yixihan
 * @create : 2022-01-11-6:41
 */
public class Solution {

    private int flag = 0;

    /**
     * 0 : 逃逸失败
     * 1 : 遇到期望方格
     * 2 : 逃逸成功
     */
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        if (blocked.length == 0) {
            return true;
        }

        // 封锁方格 Set 集
        Set<Long> blockSet = new HashSet<>();

        for (int[] block : blocked) {
            blockSet.add (key(block[0], block[1]));
        }

        // 开始方格和目标方格在封锁方格上面，也是可达的
        blockSet.remove (key (source[0], source[1]));
        blockSet.remove (key (target[0], target[1]));

        // 最大步数为：开始方格在角落，所有的封锁方格斜边包围为三角形
        int maxStep = (blockSet.size () * blockSet.size ()) >> 1;

        dfs (blockSet, maxStep, source[0], source[1], source, target, new HashSet<> ());

        if (flag == 2) {
            // 当source开始的DFS发生逃逸时，需要计算target开始的DFS
            flag = 0;
            dfs (blockSet, maxStep, target[0], target[1], target, source, new HashSet<> ());
        }

        return flag != 0;
    }

    private void dfs(Set<Long> blockSet, int maxStep, int x, int y, int[] start, int[] expect, HashSet<Long> visited) {

        // 遇到期望方格或成功找到出路, 退出
        if (flag != 0) {
            return;
        }

        if (x < 0 || y < 0 || x > 999999 || y > 999999) {
            return;
        }

        // 遇到期望方格, 退出
        if (x == expect[0] && y == expect[1]) {
            flag = 1;
            return;
        }

        long key = key (x, y);

        // 遇到封锁方格或方格已被访问过
        if (blockSet.contains (key) || visited.contains (key)) {
            return;
        }

        visited.add (key);

        // 找到出路
        if (Math.abs (start[0] - x) >= blockSet.size () ||
                Math.abs (start[1] - y) >= blockSet.size () ||
                visited.size () >= maxStep) {
            flag = 2;
            return;
        }

        dfs (blockSet, maxStep, x - 1, y, start, expect, visited);
        dfs (blockSet, maxStep, x + 1, y, start, expect, visited);
        dfs (blockSet, maxStep, x, y - 1, start, expect, visited);
        dfs (blockSet, maxStep, x, y + 1, start, expect, visited);
    }

    /**
     * (x, y) 映射为唯一 key (Long)
     * @param x x
     * @param y y
     * @return key (Long)
     */
    private Long key(int x, int y) {

        return (((long) x) << 20) + y;
    }

}

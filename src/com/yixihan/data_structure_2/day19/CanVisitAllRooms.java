package com.yixihan.data_structure_2.day19;

import java.util.List;

/**
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。
 * 你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * <p>
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。
 * 你可以拿上所有钥匙去解锁其他房间。
 * <p>
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。
 * 如果能进入 所有 房间返回 true，否则返回 false。
 * <p>
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * <p>
 * 输入：rooms = [[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 *
 * @author : yixihan
 * @create : 2022-04-11-16:18
 */
public class CanVisitAllRooms {
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size ()];
        dfs (rooms, 0);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int index) {
        if (visited[index]) {
            return;
        }
        List<Integer> room = rooms.get (index);
        visited[index] = true;

        for (Integer key : room) {
            dfs (rooms, key);
        }
    }
}

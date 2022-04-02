package com.yixihan.month03.day0104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
 *
 * 图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
 *
 * 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
 *
 * 在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。
 * 例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
 *
 * 此外，猫无法移动到洞中（节点 0）。
 *
 * 然后，游戏在出现以下三种情形之一时结束：
 *
 * 如果猫和老鼠出现在同一个节点，猫获胜。
 * 如果老鼠到达洞中，老鼠获胜。
 * 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
 * 给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
 *
 * 如果老鼠获胜，则返回 1；
 * 如果猫获胜，则返回 2；
 * 如果平局，则返回 0 。
 *
 * 输入：graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * 输出：0
 *
 * 输入：graph = [[1,3],[0],[3],[0,2]]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-01-04-0:43
 */
public class Solution {

    public int catMouseGame(int[][] graph) {
        int len = graph.length;
        int[][][] status = new int[len][len][2]; // 默认所有值为0
        Queue<State> queue = new LinkedList<> ();
        // 初始化
        for (int j=1; j<len; j++) {
            status[0][j][0] = 1;
            status[0][j][1] = 1;
            queue.offer(new State(0, j, 0, 1));
            queue.offer(new State(0, j, 1, 1));
        }
        for (int i=1; i<len; i++) {
            status[i][i][0] = 2;
            status[i][i][1] = 2;
            queue.offer(new State(i, i, 0, 2));
            queue.offer(new State(i, i, 1, 2));
        }
        // 遍历queue
        while (!queue.isEmpty()) {
            State s = queue.poll();
            if (s.k==0) { // 1 此步轮到鼠行动
                if (s.val == 1) { // 1.1 此步鼠
                    for (int pre : graph[s.j]) {
                        boolean mouseWin = true;
                        for (int preNext : graph[pre]) {
                            if (preNext!=0 && status[s.i][preNext][0]!=1) { // 此处k=0须注意
                                mouseWin = false;
                                break;
                            }
                        }
                        if ( mouseWin && status[s.i][pre][1]==0 && pre!=0 ) {
                            status[s.i][pre][1]=1;
                            queue.offer(new State(s.i, pre, 1, 1));
                            // System.out.printf("Set location (%d, %d, %d) as %d\n", s.i, pre, 1, 1);
                        }
                    }
                } else { // 1.2 此步猫胜
                    for (int pre : graph[s.j]) {
                        if (status[s.i][pre][1] == 0 && pre!=0) {
                            // 如果还没被明确判断胜负过，才能在此处判断，并且放入队列
                            status[s.i][pre][1] = 2;
                            queue.offer(new State(s.i, pre, 1, 2));
                            // System.out.printf("Set location (%d, %d, %d) as %d\n", s.i, pre, 1, 2);
                        }
                    }
                }
            } else { // 2. 此步轮到猫行动
                if (s.val == 1) { // 2.1 此步鼠胜
                    for (int pre : graph[s.i]) {
                        if (status[pre][s.j][0] == 0 && s.j!=0) {
                            status[pre][s.j][0] = 1;
                            queue.offer(new State(pre, s.j, 0, 1));
                            // System.out.printf("Set location (%d, %d, %d) as %d\n", pre, s.j, 0, 1);
                        }
                    }
                } else { // 2.2 此步猫胜
                    for (int pre : graph[s.i]) {
                        boolean catWin = true;
                        for (int preNext : graph[pre]) {
                            if (status[preNext][s.j][1]!=2 && s.j!=0) {
                                catWin = false;
                                break;
                            }
                        }
                        if (catWin && status[pre][s.j][0] == 0 && s.j!=0) {
                            status[pre][s.j][0] = 2;
                            queue.offer(new State(pre, s.j, 0, 2));
                            // System.out.printf("Set location (%d, %d, %d) as %d\n", pre, s.j, 0, 2);
                        }
                    }
                }
            }
        }

        // 最后返回初始位置
        return status[1][2][0];
    }
}

class State {
    int i;
    int j;
    int k;
    int val;
    public State(int i, int j, int k, int val) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.val = val;
    }
}


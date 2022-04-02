package com.yixihan.programming_ability_2.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * <p>
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。
 * 对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 * <p>
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，
 * 直到所有的员工都得知这条紧急消息。
 * <p>
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，
 * 他的所有直属下属都可以开始传播这一消息）。
 * <p>
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 * <p>
 * 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
 * 输出：0
 * 解释：公司总负责人是该公司的唯一一名员工。
 * <p>
 * 输入：n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * 输出：1
 * 解释：id = 2 的员工是公司的总负责人，也是其他所有员工的直属负责人，他需要 1 分钟来通知所有员工。
 * 上图显示了公司员工的树结构。
 *
 * @author : yixihan
 * @create : 2022-04-02-12:49
 */
public class NumOfMinutes {
    int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] _informTime) {
        if (n == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<> ();
        informTime = _informTime;
        for (int i = 0; i < manager.length; i++) {
            map.computeIfAbsent (manager[i], v -> new ArrayList<> ()).add (i);
        }

        return dfs (map, headID);
    }

    private int dfs(Map<Integer, List<Integer>> map, int cur) {
        if (informTime[cur] == 0) {
            return 0;
        }

        int max = 0;

        for (Integer nei : map.getOrDefault (cur, new ArrayList<> ())) {
            max = Math.max (max, dfs (map, nei));
        }

        return informTime[cur] + max;
    }
}

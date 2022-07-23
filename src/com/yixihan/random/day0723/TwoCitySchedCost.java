package com.yixihan.random.day0723;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。
 * 第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
 * <p>
 * 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
 * <p>
 * 输入：costs = [[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 a 市，费用为 10。
 * 第二个人去 a 市，费用为 30。
 * 第三个人去 b 市，费用为 50。
 * 第四个人去 b 市，费用为 20。
 * <p>
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 * <p>
 * 输入：costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * 输出：1859
 * <p>
 * 输入：costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * 输出：3086
 *
 * @author : yixihan
 * @create : 2022-07-23-12:59
 */
public class TwoCitySchedCost {

    /**
     * 按 A B 两地票价之差逆序
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort (costs, (o1, o2) -> Math.abs (o2[0] - o2[1]) - Math.abs (o1[0] - o1[1]));

        int ans = 0;
        int cntA = 0;
        int cntB = 0;
        int len = costs.length;
        int n = len / 2;

        for (int[] cost : costs) {
            System.out.println (Arrays.toString (cost));
            if (cost[0] < cost[1] && cntA < n) {
                cntA++;
                ans += cost[0];
                System.out.println ("choose A");
            } else if (cost[0] > cost[1] && cntB < n) {
                cntB++;
                ans += cost[1];
                System.out.println ("choose B");
            } else {
                if (cntA > cntB) {
                    cntB++;
                    ans += cost[1];
                    System.out.println ("choose B");
                } else {
                    cntA++;
                    ans += cost[0];
                    System.out.println ("choose A");
                }
            }
        }

        return ans;
    }
}

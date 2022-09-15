package com.yixihan.random.day0915;

import java.util.HashMap;
import java.util.Map;

/**
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * <p>
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
 * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。
 * <p>
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，
 * 返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * <p>
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 *
 * @author : yixihan
 * @create : 2022-09-15-10:45
 */
public class MasterMind {

    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> map1 = new HashMap<> ();
        Map<Character, Integer> map2 = new HashMap<> ();
        char[] arr1 = solution.toCharArray ();
        char[] arr2 = guess.toCharArray ();
        int val1 = 0;
        int val2 = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                val1++;
            } else {
                map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);
                map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet ()) {
            val2 += Math.min (entry.getValue (), map2.getOrDefault (entry.getKey (), 0));
        }

        return new int[]{val1, val2};
    }
}

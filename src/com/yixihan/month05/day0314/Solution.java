package com.yixihan.month05.day0314;

import java.util.*;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 *
 *
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *
 * @author : yixihan
 * @create : 2022-03-14-10:26
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 方法一 : 暴力题解
//        List<String> list = new ArrayList<> ();
//        int minIndexSum = Integer.MAX_VALUE;
//
//        for (int i = 0; i < list1.length; i++) {
//            String val = list1[i];
//            int index2 = search (list2, val);
//            if (index2 >= 0) {
//                System.out.println ("index2 : " + index2 + ", i : " + i);
//                if (i + index2 < minIndexSum) {
//                    minIndexSum = i + index2;
//                    list.clear ();
//                    list.add (val);
//                } else if (i + index2 == minIndexSum) {
//                    list.add (val);
//                }
//            }
//        }
//
//        return list.toArray (new String[0]);

        // 方法二 : 利用 HashMap
        Map<String, Integer> map1 = new HashMap<> (list1.length);
        Map<String, Integer> map2 = new HashMap<>(list2.length);
        List<String> list = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            map1.put (list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put (list2[i], i);
        }

        for (HashMap.Entry<String, Integer> entry : map1.entrySet ()) {
            if (map2.containsKey (entry.getKey ())) {
                Integer entry2 = map2.get (entry.getKey ());
                if (minIndexSum > entry.getValue () + entry2) {
                    minIndexSum = entry.getValue () + entry2;
                    list.clear ();
                    list.add (entry.getKey ());
                } else if (minIndexSum == entry.getValue () + entry2) {
                    list.add (entry.getKey ());
                }
            }
        }

        return list.toArray (new String[0]);
    }

    private int search (String[] list, String target) {
        for (int i = 0; i < list.length; i++) {
            if (target.equals (list[i])) {
                return i;
            }
        }

        return -1;
    }
}

package com.yixihan.month02.day1125;

import java.util.*;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *
 * @author : yixihan
 * @create : 2021-11-25-15:51
 */
public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {

                if (list1[i].equals(list2[j])) {
                    map.put(list1[i], i + j);
                    break;
                }
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(entrySet);
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        int minValue = list.get(0).getValue();
        StringBuilder builder = new StringBuilder(32);

        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() != minValue) {
                break;
            }
            builder.append(entry.getKey()).append("::");
        }

        return builder.toString().split("::");
    }
}

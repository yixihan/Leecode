package com.yixihan.month13.day1029;

import java.util.List;

/**
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * <p>
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * <p>
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * <p>
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 *
 * @author yixihan
 * @date 2022-10-29-16:31
 */
public class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        int count = 0;
        if ("type".equals (ruleKey)) {
            index = 0;
        } else if ("color".equals (ruleKey)) {
            index = 1;
        } else if ("name".equals (ruleKey)) {
            index = 2;
        }

        for (List<String> item : items) {
            if (item.get (index).equals (ruleValue)) {
                count++;
            }
        }

        return count;
    }


}

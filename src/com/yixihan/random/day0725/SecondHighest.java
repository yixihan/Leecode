package com.yixihan.random.day0725;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * <p>
 * 混合字符串 由小写英文字母和数字组成。
 * <p>
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * <p>
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *
 * @author : yixihan
 * @create : 2022-07-25-9:41
 */
public class SecondHighest {

    public int secondHighest(String s) {
        Set<Integer> set = new HashSet<> ();
        for (char c : s.toCharArray ()) {
            if (c >= '0' && c <= '9') {
                set.add (c - '0');
            }
        }

        List<Integer> list = new ArrayList<> (set);
        list.sort (Integer::compareTo);
        return list.size () >= 2 ? list.get (list.size () - 2) : -1;
    }
}

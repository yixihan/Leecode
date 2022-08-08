package com.yixihan.random.day0808;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 *
 * @author : yixihan
 * @create : 2022-08-08-8:32
 */
public class Reformat {

    public String reformat(String s) {
        List<Character> letterList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();

        for (char c : s.toCharArray ()) {
            if (c >= '0' && c <= '9') {
                numList.add (c);
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                letterList.add (c);
            }
        }

        if (Math.abs (letterList.size () - numList.size ()) > 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder ();

        if (letterList.size () > numList.size ()) {
            helper (letterList, numList, sb);
        } else {
            helper (numList, letterList, sb);
        }

        return sb.toString ();
    }

    private void helper(List<Character> list1, List<Character> list2, StringBuilder sb) {
        for (int i = 0 ; i < list2.size (); i++) {
            sb.append (list1.get (i)).append (list2.get (i));
        }

        if (list1.size () > list2.size ()) {
            sb.append (list1.get (list2.size ()));
        }
    }
}

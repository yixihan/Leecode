package com.yixihan.month10.day0803;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * <p>
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * <p>
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 *
 * @author : yixihan
 * @create : 2022-08-03-8:57
 */
public class Solution {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            //模拟往后移一个元素
            StringBuilder sb = new StringBuilder (s);
            for (int i = 1; i < s.length (); i++) {
                //第一个元素移动到最后
                sb.append (sb.charAt (0)).deleteCharAt (0);
                if (sb.toString ().compareTo (s) < 0) {
                    s = sb.toString ();
                }
            }
            return s;
        } else {
            //直接排序
            char[] chars = s.toCharArray ();
            Arrays.sort (chars);
            return new String (chars);
        }
    }
}

package com.yixihan.month04.day0202;

import java.util.function.Function;

/**
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，
 * 反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
 *
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、直到下标 3 结束（含下标 3 ）。
 * 结果字符串将会是 "dcbaefd" 。
 * 返回 结果字符串 。
 *
 * 输入：word = "abcdefd", ch = "d"
 * 输出："dcbaefd"
 * 解释："d" 第一次出现在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "dcbaefd" 。
 *
 * 输入：word = "xyxzxe", ch = "z"
 * 输出："zxyxxe"
 * 解释："z" 第一次也是唯一一次出现是在下标 3 。
 * 反转从下标 0 到下标 3（含下标 3）的这段字符，结果字符串是 "zxyxxe" 。
 *
 * 输入：word = "abcd", ch = "z"
 * 输出："abcd"
 * 解释："z" 不存在于 word 中。
 * 无需执行反转操作，结果字符串是 "abcd" 。
 *
 * @author : yixihan
 * @create : 2022-02-02-17:55
 */
public class Solution {

    public String reversePrefix(String word, char ch) {

        int index = word.indexOf (ch);

        if (index > 0) {
            StringBuilder str1 = new StringBuilder(word.substring (0, ++index));
            str1.reverse ().append (word.substring (index));

            return str1.toString ();
        } else {
            return word;
        }
    }
}

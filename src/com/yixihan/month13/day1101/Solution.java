package com.yixihan.month13.day1101;

/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 *
 * @author yixihan
 * @date 2022-11-01-9:06
 */
public class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = buildStr (word1);
        String str2 = buildStr (word2);

        return str1.equals (str2);
    }

    private String buildStr(String[] words) {
        StringBuilder sb = new StringBuilder ();

        for (String word : words) {
            sb.append (word);
        }

        return sb.toString ();
    }
}

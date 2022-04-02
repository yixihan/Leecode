package com.yixihan.programming_ability_1.day9;

/**
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 *
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 *
 * 输入：s = "1326#"
 * 输出："acz"
 *
 * 输入：s = "25#"
 * 输出："y"
 *
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 *
 * @author : yixihan
 * @create : 2022-03-19-12:05
 */
public class FreqAlphabets {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder ();
        char[] chars = s.toCharArray ();
        int n = chars.length;

        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == '#') {
                sb.append((char) (chars[--i] - 48 + (chars[--i] - 48) * 10 + 96));
            } else {
                sb.append((char) (chars[i] + 48));
            }
        }

        return sb.reverse ().toString ();
    }
}

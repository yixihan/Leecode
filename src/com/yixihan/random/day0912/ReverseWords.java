package com.yixihan.random.day0912;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 *
 * @author : yixihan
 * @create : 2022-09-12-11:04
 */
public class ReverseWords {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder ();
        for (String str : s.split (" ")) {
            sb.append (new StringBuilder (str).reverse ());
            sb.append (" ");
        }

        return sb.deleteCharAt (sb.length () - 1).toString ();
    }
}

package com.yixihan.offer.day03;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @author : yixihan
 * @create : 2022-02-23-13:02
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length (); i++) {
            if (sb.charAt (i) == ' ') {
                sb.deleteCharAt (i);
                sb.insert (i, "%20");
            }
        }

        return sb.toString ();
    }
}

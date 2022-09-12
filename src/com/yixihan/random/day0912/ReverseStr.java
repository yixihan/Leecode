package com.yixihan.random.day0912;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * @author : yixihan
 * @create : 2022-09-12-10:48
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder ();
        StringBuilder tmp = new StringBuilder ();
        int cnt = 0;
        boolean flag = true;
        for (char c : s.toCharArray ()) {
            if (cnt++ < k) {
                tmp.append (c);
            } else {
                if (flag) {
                    sb.append (tmp.reverse ());
                } else {
                    sb.append (tmp);
                }
                tmp = new StringBuilder ();
                tmp.append (c);
                flag = !flag;
                cnt = 0;
            }
        }
        if (flag) {
            sb.append (tmp.reverse ());
        } else {
            sb.append (tmp);
        }

        return sb.toString ();
    }
}

package com.yixihan.random.day0918;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 *
 * @author : yixihan
 * @create : 2022-09-18-8:46
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {
        s = buildStr (s);
        t = buildStr (t);
        System.out.println (s);
        System.out.println (t);
        return s.equals (t);
    }

    private String buildStr (String str) {
        StringBuilder sb = new StringBuilder ();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (sb.length () > 0) {
                    sb.deleteCharAt (sb.length () - 1);
                }
            } else {
                sb.append (c);
            }
        }

        return sb.toString ();
    }
}

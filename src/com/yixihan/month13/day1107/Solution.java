package com.yixihan.month13.day1107;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 * <p>
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。
 * 此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * <p>
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * <p>
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * <p>
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * <p>
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * <p>
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 *
 * @author yixihan
 * @date 2022/11/7 9:01
 */
public class Solution {

    public List<String> ambiguousCoordinates(String s) {
        int n = s.length () - 2;
        List<String> res = new ArrayList<> ();
        s = s.substring (1, s.length () - 1);
        for (int l = 1; l < n; ++l) {
            List<String> lt = getPos (s.substring (0, l));
            if (lt.isEmpty ()) {
                continue;
            }
            List<String> rt = getPos (s.substring (l));
            if (rt.isEmpty ()) {
                continue;
            }
            for (String i : lt) {
                for (String j : rt) {
                    res.add ("(" + i + ", " + j + ")");
                }
            }
        }
        return res;
    }

    public List<String> getPos(String s) {
        List<String> pos = new ArrayList<> ();
        if (s.charAt (0) != '0' || "0".equals (s)) {
            pos.add (s);
        }
        for (int p = 1; p < s.length (); ++p) {
            if ((p != 1 && s.charAt (0) == '0') || s.charAt (s.length () - 1) == '0') {
                continue;
            }
            pos.add (s.substring (0, p) + "." + s.substring (p));
        }
        return pos;
    }
}

package com.yixihan.satine;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 *
 * @author : yixihan
 * @create : 2022-03-05-14:59
 */
public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length () != s2.length ()) {
            return false;
        }

        String str = s2 + s2;
        int length = s1.length ();

        return str.contains (s1);
    }
}

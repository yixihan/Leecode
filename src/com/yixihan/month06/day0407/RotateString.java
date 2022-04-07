package com.yixihan.month06.day0407;

/**
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * <p>
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * <p>
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * <p>
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * <p>
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *
 * @author : yixihan
 * @create : 2022-04-07-14:06
 */
public class RotateString {
    public boolean rotateString(String s, String goal) {
        s = s + s;
        return s.length () / 2 == goal.length () && s.indexOf (goal) >= 0;
    }
}

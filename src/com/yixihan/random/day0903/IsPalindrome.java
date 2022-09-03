package com.yixihan.random.day0903;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个回文串。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是回文串，返回 true ；否则，返回 false 。
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * <p>
 * 输入："race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 * @author : yixihan
 * @create : 2022-09-03-13:32
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder ();

        for (char c : s.toLowerCase ().toCharArray ()) {
            if (c >= '0' && c <= '9') {
                sb.append (c);
            } else if (c >= 'a' && c <= 'z') {
                sb.append (c);
            }
        }

        return sb.reverse ().toString ().equals (sb.toString ());
    }
}

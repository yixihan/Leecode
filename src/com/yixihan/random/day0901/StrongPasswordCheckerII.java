package com.yixihan.random.day0901;

/**
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * <p>
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 * <p>
 * 输入：password = "IloveLe3tcode!"
 * 输出：true
 * 解释：密码满足所有的要求，所以我们返回 true 。
 * <p>
 * 输入：password = "Me+You--IsMyDream"
 * 输出：false
 * 解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
 * <p>
 * 输入：password = "1aB!"
 * 输出：false
 * 解释：密码不符合长度要求。所以我们返回 false 。
 *
 * @author : yixihan
 * @create : 2022-09-01-14:57
 */
public class StrongPasswordCheckerII {

    public boolean strongPasswordCheckerII(String password) {
        return judgeLength (password) && judgeArr (password);
    }

    private boolean judgeLength (String password) {
        return password.length () >= 8;
    }

    private boolean judgeArr (String password) {

        boolean lower = false;
        boolean upper = false;
        boolean num = false;
        boolean specialC = false;
        String str = "!@#$%^&*()-+";

        char[] charArray = password.toCharArray ();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (i > 0 && charArray[i - 1] == c) {
                return false;
            }
            if (c >= '0' && c <= '9') {
                num = true;
            }
            if (c >= 'a' && c <= 'z') {
                lower = true;
            }
            if (c >= 'A' && c <= 'Z') {
                upper = true;
            }
            if (str.contains (String.valueOf (c))) {
                specialC = true;
            }
        }

        return num && lower && upper && specialC;
    }
}

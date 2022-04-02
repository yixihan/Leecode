package com.yixihan.satine;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * @author : yixihan
 * @create : 2022-03-04-13:44
 */
public class CompressString {
    public String compressString(String S) {

        if (S == null || S.length () == 0) {
            return S;
        }

        StringBuilder sb = new StringBuilder(String.valueOf (S.charAt (0)));

        int count = 1;

        for (int i = 1; i < S.length (); i++) {

            if (S.charAt (i) != sb.charAt (sb.length () - 1)) {
                sb.append (count).append (S.charAt (i));
                count = 1;
            } else {
                count++;
            }
        }
        sb.append (count);

        String ans = sb.toString ();
        System.out.println (ans);
        return ans.length () >= S.length () ? S : ans;
    }
}

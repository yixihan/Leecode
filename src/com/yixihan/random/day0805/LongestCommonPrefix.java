package com.yixihan.random.day0805;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author : yixihan
 * @create : 2022-08-05-15:32
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder ();
        char[][] letters = new char[strs.length][];
        int index = 0;
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            letters[index++] = str.toCharArray ();
            len = Math.min (len, str.length ());
        }

        for (int j = 0; j < len; j++) {
            char c = letters[0][j];
            for (int i = 1; i < strs.length; i++) {
                if (c != letters[i][j]) {
                    return sb.toString ();
                }
            }
            sb.append (c);
        }

        return sb.toString ();
    }
}

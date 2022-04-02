package com.yixihan.offer.day03;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * @author : yixihan
 * @create : 2022-02-23-13:07
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {

        String str1 = s.substring (0, n);
        String str2 = s.substring (n);

        return str2 + str1;
    }
}

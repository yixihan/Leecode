package com.yixihan.satine;

import java.util.ArrayList;
import java.util.List;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 *
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *
 * @author : yixihan
 * @create : 2022-03-03-17:18
 */
public class ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        char[] oldVal = S.toCharArray ();


        for (int i = 0; i < length; i++) {
            if (oldVal[i] == ' ') {
                sb.append ("%20");
            } else {
                sb.append ((oldVal[i]));
            }

        }

        return sb.toString ();
    }
}

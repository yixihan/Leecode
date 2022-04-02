package com.yixihan.month05.day0301;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * @author : yixihan
 * @create : 2022-03-01-12:02
 */
public class Convert {
    public String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add (new ArrayList<> ());
        }

        int count = 0;
        boolean flag = false;
        for (int i = 0; i < s.length (); i++) {
            if (count + 1 == numRows) {
                flag = true;
            } else if (count == 0) {
                flag = false;
            } else if (count < 0) {
                count = 0;
            }

            list.get (count).add (s.charAt (i));

            if (flag) {
                count--;
            } else {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder(s.length ());
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < list.get (i).size (); j++) {
                sb.append (list.get (i).get (j));

            }
        }

        return sb.toString ();
    }
}

package com.yixihan.month03.day1226;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，
 * 其中 second 紧随 first 出现，third 紧随 second 出现。
 *
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 *
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 *
 * @author : yixihan
 * @create : 2021-12-26-0:13
 */
public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();

        String[] sp = text.split (" ");

        for (int i = 1; i < sp.length - 1; i++) {

            if (sp[i - 1].equals (first) && sp[i].equals (second)) {
                list.add (sp[i + 1]);
            }

        }

        String[] third = new String[list.size ()];
        for (int i = 0; i < list.size (); i++) {
            third[i] = list.get (i);
        }

        return third;
    }
}

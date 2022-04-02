package com.yixihan.month01.day1031;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 *
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 *
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 *
 * @author : yixihan
 * @create : 2021-10-31-23:18
 */
public class FindWords {
    public String[] findWords(String[] words) {

        String[] str = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        ArrayList<String> res = new ArrayList<>(words.length);

        for (String word : words) {
            char[] array = word.toLowerCase().toCharArray();
            int j = 0;
            for (; j < str.length; j++) {

                if (str[j].indexOf(array[0]) >= 0) {
                    break;
                }
            }

            int k = 0;
            for (; k < array.length; k++) {
                if (str[j].indexOf(array[k]) < 0) {
                    break;
                }
            }

            if (k >= array.length) {
                res.add(word);
            }


        }
        return res.toArray(new String[0]);
    }

    @Test
    public void test () {

        String[] str = {"Hello","Alaska","Dad","Peace","adsdf","sfd"};
        String[] words = findWords(str);

        Arrays.stream(words).forEach(System.out::println);

        ArrayList<String> list = new ArrayList<>();



    }
}

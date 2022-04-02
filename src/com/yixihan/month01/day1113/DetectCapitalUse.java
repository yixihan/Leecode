package com.yixihan.month01.day1113;

import org.junit.jupiter.api.Test;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 * 输入：word = "USA"
 * 输出：true
 *
 * 输入：word = "FlaG"
 * 输出：false
 *
 * @author : yixihan
 * @create : 2021-11-13-1:16
 */
public class DetectCapitalUse {


    /**
     * 暴力匹配
     */
    public boolean detectCapitalUse(String word) {

        if (word.toUpperCase().equals(word)) {
            return true;
        } else if (word.toLowerCase().equals(word)) {
            return true;
        } else {
            StringBuilder builder = new StringBuilder(word.length());
            builder.append(word.substring(0, 1).toUpperCase());
            builder.append(word.substring(1).toLowerCase());

            return builder.toString().equals(word);
        }
    }


    /**
     * 统计大写字母的个数
     * 效率更高, 但是内存消耗更大
     */
    public boolean detectCapitalUse1 (String word) {
        char[] s = word.toCharArray();

        // 统计大写字母出现的次数
        int count = 0;
        for (char c : s) {
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }

        if (count == 0 || count == s.length) {
            return true;
        }
        return count == 1 && s[0] >= 'A' && s[0] <= 'Z';
    }


    /**
     * 若 word 的长度为 1, 则必定正确，因此考虑 word 的长度大于等于 2 的情况
     * word 要正确的条件有 :
     * 从第二个字符开始的所有字符, 只能同大写或同小写
     * 若为同大写, 则第一个字符只能为大写
     * 若为同小写, 则第一个字符串可以为大写或小写
     */
    public boolean detectCapitalUse2 (String word) {
        if (word.length() == 1) {
            return true;
        }

        //第二个字符的大小写
        boolean base = f(word.charAt(1));
        for (int i = 2; i < word.length(); i++) {

            //若与第二个字符不是同大写或同小写,则必定错误
            if (f(word.charAt(i)) != base) {
                return false;
            }
        }
        //后续全为大写，取决于第一个字符是否为大写
        //后续全为小写，必定正确
        return !base || f(word.charAt(0));
    }


    /**
     * true为大写，false为小写
     */
    public boolean f(char c) {
        return 'A' <= c && c <= 'Z';
    }



    @Test
    public void test () {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leecode"));
        System.out.println(detectCapitalUse("China"));
        System.out.println(detectCapitalUse("YixIHan"));

        System.out.println();

        System.out.println(detectCapitalUse1("USA"));
        System.out.println(detectCapitalUse1("leecode"));
        System.out.println(detectCapitalUse1("China"));
        System.out.println(detectCapitalUse1("YixIHan"));
    }
}

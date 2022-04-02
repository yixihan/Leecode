package com.yixihan.month04.day0127;

/**
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。
 * 每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
 *
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 *
 * 仅由小写字母、连字符和/或标点（不含数字）。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
 *
 * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
 *
 * 输入：sentence = "cat and  dog"
 * 输出：3
 * 解释：句子中的有效单词是 "cat"、"and" 和 "dog"
 *
 * 输入：sentence = "!this  1-s b8d!"
 * 输出：0
 * 解释：句子中没有有效单词
 * "!this" 不是有效单词，因为它以一个标点开头
 * "1-s" 和 "b8d" 也不是有效单词，因为它们都包含数字
 *
 * 输入：sentence = "alice and  bob are playing stone-game10"
 * 输出：5
 * 解释：句子中的有效单词是 "alice"、"and"、"bob"、"are" 和 "playing"
 * "stone-game10" 不是有效单词，因为它含有数字
 *
 * 输入：sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."
 * 输出：6
 * 解释：句子中的有效单词是 "he"、"bought"、"pencils,"、"erasers,"、"and" 和 "pencil-sharpener."
 *
 * @author : yixihan
 * @create : 2022-01-27-9:23
 */
public class Solution {
    public int countValidWords(String sentence) {
        String[] words = sentence.split (" ");
        int count = 0;

        for (String word : words) {

            int j = 0;
            int hCount = 0;
            for (; j < word.length (); j++) {
                char val = word.charAt (j);
                if ((val >= '0' && val <= '9')) {
                    break;
                } else if ((j != word.length () - 1) && (val == '!' || val == ',' || val == '.')) {
                    break;
                } else if ((j == 0 || j == word.length () - 1) && val == '-') {
                    break;
                } else if (val == '-' && !(word.charAt (j - 1) >= 'a' && word.charAt (j - 1) <= 'z' && word.charAt (j + 1) >= 'a' && word.charAt (j + 1) <= 'z')) {
                    break;
                } else if ((j != 0 && j != word.length () - 1) && val == '-') {
                    hCount++;
                    if (hCount > 1) {
                        break;
                    }
                }
            }
            if (j >= word.length () && word.length () != 0) {
                count++;
                System.out.println (word);
            }
        }
        return count;
    }
}

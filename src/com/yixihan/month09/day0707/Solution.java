package com.yixihan.month09.day0707;

import java.util.Collections;
import java.util.List;

/**
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *
 * @author : yixihan
 * @create : 2022-07-07-8:04
 */
public class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort (dictionary);
        String[] sentences = sentence.split (" ");
        StringBuilder sb = new StringBuilder ();
        for (String word : sentences) {
            boolean flag = false;
            for (String dict : dictionary) {
                if (word.indexOf (dict) == 0) {
                    flag = true;
                    sb.append (dict).append (" ");
                    break;
                }
            }

            if (!flag) {
                sb.append (word).append (" ");
            }
        }

        return sb.deleteCharAt (sb.length () - 1).toString ();
    }
}

package com.yixihan.month07.day0421;

/**
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 * @author : yixihan
 * @create : 2022-04-21-14:57
 */
public class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder ();
        String[] words = sentence.split (" ");
        int index = 1;

        for (String word : words) {
            if (word.charAt (0) == 'a' || word.charAt (0) == 'e' || word.charAt (0) == 'i' || word.charAt (0) == 'o' || word.charAt (0) == 'u' || word.charAt (0) == 'A' || word.charAt (0) == 'E' || word.charAt (0) == 'I' || word.charAt (0) == 'O' || word.charAt (0) == 'U') {
                sb.append (word).append ("ma");
            } else {
                sb.append (word.substring (1, word.length ())).append (word.charAt (0)).append ("ma");
            }

            for (int i = 0; i < index; i++) {
                sb.append ("a");
            }
            sb.append (" ");
            index++;
        }

        sb.deleteCharAt (sb.length () - 1);

        return sb.toString ();
    }
}

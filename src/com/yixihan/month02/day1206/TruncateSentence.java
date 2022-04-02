package com.yixihan.month02.day1206;

/**
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 *
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s 和一个整数 k ，请你将 s 截断，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
 *
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 *
 * 输入：s = "What is the solution to this problem", k = 4
 * 输出："What is the solution"
 * 解释：
 * s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
 * 前 4 个单词为 ["What", "is", "the", "solution"]
 * 因此，应当返回 "What is the solution"
 *
 * 输入：s = "chopper is not a tanuki", k = 5
 * 输出："chopper is not a tanuki"
 * @author : yixihan
 * @create : 2021-12-06-15:19
 */
public class TruncateSentence {

    public String truncateSentence(String s, int k) {

        String[] split = s.split (" ");
        StringBuilder builder = new StringBuilder(s.length () / k);

        for (int i = 0; i < k; i++) {

            if (i > 0) {
                builder.append (" ").append (split[i]);
            } else {
                builder.append (split[i]);
            }
        }

        return builder.toString ();
    }
}

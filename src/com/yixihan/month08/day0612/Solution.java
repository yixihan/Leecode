package com.yixihan.month08.day0612;

import java.util.ArrayList;
import java.util.List;

/**
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *
 * @author : yixihan
 * @create : 2022-06-12-11:09
 */
public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> ans = new ArrayList<> ();
        for (String word : words) {
            if (judge (word.toCharArray (), pattern.toCharArray ())) {
                ans.add (word);
            }
        }

        return ans;
    }

    private boolean judge(char[] word, char[] pattern) {
        int[] p1 = new int[27];
        int[] p2 = new int[27];
        boolean match = true;

        for (int i = 0; i < pattern.length; i++) {
            int index = word[i] - 'a' + 1;
            int value = pattern[i] - 'a' + 1;
            if ((p1[index] != 0 && p1[index] != value) || (p2[value] != 0 && p2[value] != index)) {
                match = false;
                break;
            }
            p1[index] = value;
            p2[value] = index;
        }

        return match;
    }
}

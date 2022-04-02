package com.yixihan.programming_ability_1.day8;

/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 *
 * 返回 合并后的字符串 。
 *
 *
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 *
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 *
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *
 * @author : yixihan
 * @create : 2022-03-18-14:29
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length ();
        int n2 = word2.length ();
        StringBuilder sb = new StringBuilder (n1 + n2);

        for (int i = 0; i < Math.min (n1, n2); i++) {
            sb.append (word1.charAt (i)).append (word2.charAt (i));
        }

        if (n1 > n2) {
            sb.append (word1.substring (n2, n1));
        } else if (n1 < n2) {
            sb.append (word2.substring (n1, n2));
        }

        return sb.toString ();
    }
}

package com.yixihan.month13.day1023;

/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * <p>
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * <p>
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *
 * @author yixihan
 * @date 2022-10-23-10:45
 */
public class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder ();
        char[] arr1 = word1.toCharArray ();
        char[] arr2 = word2.toCharArray ();
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < arr1.length || idx2 < arr2.length) {
            if (idx1 < arr1.length) {
                sb.append (arr1[idx1++]);
            }
            if (idx2 < arr2.length) {
                sb.append (arr2[idx2++]);
            }
        }

        return sb.toString ();
    }
}

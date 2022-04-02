package com.yixihan.month05.day0305;

/**
 * 给你两个字符串 a 和 b，请返回 这两个字符串中 最长的特殊序列  的长度。如果不存在，则返回 -1 。
 *
 * 「最长特殊序列」 定义如下：该序列为 某字符串独有的最长子序列（即不能是其他字符串的子序列） 。
 *
 * 字符串 s 的子序列是在从 s 中删除任意数量的字符后可以获得的字符串。
 *
 * 例如，"abc" 是 "aebdc" 的子序列，因为删除 "aebdc" 中斜体加粗的字符可以得到 "abc" 。
 * "aebdc" 的子序列还包括 "aebdc" 、 "aeb" 和 "" (空字符串)。
 *
 * 输入: a = "aba", b = "cdc"
 * 输出: 3
 * 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
 *
 * 输入：a = "aaa", b = "bbb"
 * 输出：3
 * 解释: 最长特殊序列是 "aaa" 和 "bbb" 。
 *
 * 输入：a = "aaa", b = "aaa"
 * 输出：-1
 * 解释: 字符串 a 的每个子序列也是字符串 b 的每个子序列。同样，字符串 b 的每个子序列也是字符串 a 的子序列。
 *
 * @author : yixihan
 * @create : 2022-03-05-13:16
 */
public class FindLUSlength {
    /**
     * - s1 = 'ab',s2 = 'a',因为ab是s1独有，所以最长子序列为ab，
     * - s1 = 'ab', s2 = 'ab', 因为ab是两个串都有，ab排除，a也是两个串都有，排除，b也是两个串都有，排除。所以最长特殊序列不存在，返回-1
     * - 通过以上分析，我们可以得出结论，如果：两个串相等（不仅长度相等，内容也相等），那么他们的最长特殊序列不存在。返回-1
     * - 如果两个串长度不一样，那么长的串   永远也不可能是   短串的子序列，即len(s1) > len(s2),则最长特殊序列为s1,返回长度大的数
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {

        if (a.equals (b)) {
            return -1;
        }
        return Math.max (a.length (), b.length ());
    }
}

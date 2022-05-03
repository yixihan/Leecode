package com.yixihan.month07.day0503;

import java.util.Arrays;

/**
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * <p>
 * 有两种不同类型的日志：
 * <p>
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * <p>
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 * <p>
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 * <p>
 * 输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * @author : yixihan
 * @create : 2022-05-03-9:56
 */
public class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort (logs, (s1, s2) -> {
            String[] splits1 = s1.split (" ", 2);
            String[] splits2 = s2.split (" ", 2);

            boolean digit1 = Character.isDigit (splits1[1].charAt (0));
            boolean digit2 = Character.isDigit (splits2[1].charAt (0));

            if (!digit1 && !digit2) {
                if (splits1[1].compareTo (splits2[1]) != 0) {
                    return splits1[1].compareTo (splits2[1]);
                } else {
                    return splits1[0].compareTo (splits2[0]);
                }
            } else {
                return digit1 ? (digit2 ? 0 : 1) : -1;
            }
        });

        return logs;
    }
}

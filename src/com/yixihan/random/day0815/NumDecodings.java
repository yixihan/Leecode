package com.yixihan.random.day0815;

import java.util.HashMap;
import java.util.Map;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。*
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 *
 * @author : yixihan
 * @create : 2022-08-15-8:45
 */
public class NumDecodings {

    public int numDecodings(String s) {
        char[] arr = s.toCharArray ();
        int len = arr.length;

        if (len == 0 || len == 1 && arr[0] == '0') {
            return 0;
        }
        if (len == 1) {
            return 1;
        }

        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            dp[i + 1] = arr[i] == '0' ? 0 : dp[i];
            if (i > 0 && (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[len];
    }
}

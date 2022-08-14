package com.yixihan.random.day0814;

/**
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * <p>
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * <p>
 * 注意：
 * <p>
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 * <p>
 * 输入：num = 240, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "240" 中的 "24" ：24 能整除 240 。
 * - "240" 中的 "40" ：40 能整除 240 。
 * 所以，k 美丽值为 2 。
 * 示例 2：
 * <p>
 * 输入：num = 430043, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * - "430043" 中的 "30" ：30 不能整除 430043 。
 * - "430043" 中的 "00" ：0 不能整除 430043 。
 * - "430043" 中的 "04" ：4 不能整除 430043 。
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 *
 * @author : yixihan
 * @create : 2022-08-14-9:24
 */
public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {
        String str = Integer.toString (num);
        int len = str.length ();
        int ans = 0;

        for (int i = 0; i <= len - k; i++) {
            int val = Integer.parseInt (str.substring (i, i + k));
            if (val != 0 && num % val == 0) {
                ans++;
            }
        }

        return ans;
    }
}

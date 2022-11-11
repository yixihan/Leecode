package com.yixihan.month13.day1111;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * <p>
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 *
 * @author yixihan
 * @date 2022/11/11 8:48
 */
public class Solution {

    public boolean halvesAreAlike(String s) {
        int cnt = 0;
        int len = s.length ();
        char[] arr = s.toCharArray ();

        for (int i = 0; i < len; i++) {
            if (arr[i] == 'a' || arr[i] == 'O' || arr[i] == 'I' || arr[i] == 'E' || arr[i] == 'A' || arr[i] == 'u' || arr[i] == 'o' || arr[i] == 'i' || arr[i] == 'e' || arr[i] == 'U') {
                cnt += i < len / 2 ? 1 : -1;
            }
        }

        return cnt == 0;
    }
}

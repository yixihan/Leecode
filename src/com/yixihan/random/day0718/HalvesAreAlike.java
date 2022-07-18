package com.yixihan.random.day0718;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
 * @author : yixihan
 * @create : 2022-07-18-8:15
 */
public class HalvesAreAlike {

    public boolean halvesAreAlike(String s) {

        char[] arr = s.toCharArray ();
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        int lCnt = 0;
        int rCnt = 0;
        Set<Character> set = new HashSet<> (Arrays.asList ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        while (l < len / 2) {
            if (set.contains (arr[l])) {
                lCnt++;
            }
            if (set.contains (arr[r])) {
                rCnt++;
            }
            l++;
            r--;
        }

        System.out.println (lCnt);
        System.out.println (rCnt);

        return lCnt == rCnt;
    }
}

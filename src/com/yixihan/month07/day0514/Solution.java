package com.yixihan.month07.day0514;

import java.util.HashMap;
import java.util.Map;

/**
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 *
 * 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。
 * 如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 *
 * 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
 *
 * 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
 *
 * 输入： stickers = ["with","example","science"], target = "thehat"
 * 输出：3
 * 解释：
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 *
 * 输入：stickers = ["notice","possible"], target = "basicbasic"
 * 输出：-1
 * 解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 *
 * @author : yixihan
 * @create : 2022-05-14-8:49
 */
public class Solution {
    public int minStickers(String[] stickers, String target) {
        int len = stickers.length;
        int[][] letters = new int[len][26];
        Map<String, Integer> map = new HashMap<> ();

        for (int i = 0; i < len; i++) {
            for (char c : stickers[i].toCharArray ()) {
                letters[i][c - 'a']++;
            }
        }
        map.put ("", 0);
        return getAns (map, letters, target);
    }

    private int getAns (Map<String, Integer> map, int[][] letters, String target) {
        if (map.containsKey (target)) {
            return map.get (target);
        }
        int ans = Integer.MAX_VALUE;
        int[] tmp = new int[26];
        char[] arr = target.toCharArray ();

        for (char c : arr) {
            tmp[c - 'a']++;
        }

        for (int[] letter : letters) {
            if (letter[arr[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder ();
            for (int j = 0; j < 26; j++) {
                if (tmp[j] > 0) {
                    for (int k = 0; k < Math.max (0, tmp[j] - letter[j]); k++) {
                        sb.append ((char) ('a' + j));
                    }
                }
            }

            int a = getAns (map, letters, sb.toString ());
            if (a != -1) {
                ans = Math.min (ans, 1 + a);
            }
        }
        map.put (target, ans == Integer.MAX_VALUE ? -1 : ans);
        return map.get (target);
    }

}

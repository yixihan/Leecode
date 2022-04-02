package com.yixihan.programming_ability_1.day9;

import java.util.HashMap;
import java.util.Map;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，
 * 返回 true；否则，返回 false。
 *
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因
 * 为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * @author : yixihan
 * @create : 2022-03-19-11:50
 */
public class IsAlienSorted {
    Map<Character, Integer> map = new HashMap<> (26);

    public boolean isAlienSorted(String[] words, String order) {

        int index = 0;
        for (char c : order.toCharArray ()) {
            map.put (c, index++);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (! order (words[i], words[i + 1])) {
                return false;
            }
        }

        return true;
    }

    private boolean order (String str1, String str2) {
        int n1 = str1.length ();
        int n2 = str2.length ();
        char[] chars1 = str1.toCharArray ();
        char[] chars2 = str2.toCharArray ();
        boolean flag = false;

        for (int i = 0; i < Math.min (n1, n2); i++) {
            int index1 = map.get (chars1[i]);
            int index2 = map.get (chars2[i]);

            if (index1 > index2) {
                return false;
            } else if (index1 == index2) {
                flag = true;
            } else {
                return true;
            }
        }

        return flag && n1 < n2;
    }
}

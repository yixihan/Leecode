package com.yixihan.month8.day0517;

import java.util.HashMap;
import java.util.Map;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，
 * 只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 * @author : yixihan
 * @create : 2022-05-17-13:03
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Character> map = new HashMap<> (26);

        char index = 'a';
        for (char c : order.toCharArray ()) {
            map.put (index++, c);
        }

        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray ();
            for (int j = 0; j < arr.length; j++) {
                arr[j] = map.get (arr[j]);
            }
            words[i] = new String (arr);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].compareTo (words[i + 1]) > 0) {
                return false;
            }
        }

        return true;


    }
}

package com.yixihan.month11.day0907;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。
 * 每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 * <p>
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。
 * 如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 * <p>
 * 返回 重新排列空格后的字符串 。
 * <p>
 * 输入：text = "  this   is  a sentence "
 * 输出："this   is   a   sentence"
 * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 * <p>
 * 输入：text = " practice   makes   perfect"
 * 输出："practice   makes   perfect "
 * 解释：总共有 7 个空格和 3 个单词。7 / (3-1) = 3 个空格加上 1 个多余的空格。多余的空格需要放在字符串的末尾。
 * <p>
 * 输入：text = "hello   world"
 * 输出："hello   world"
 * <p>
 * 输入：text = "  walks  udp package   into  bar a"
 * 输出："walks  udp  package  into  bar  a "
 * <p>
 * 输入：text = "a"
 * 输出："a"
 *
 * @author : yixihan
 * @create : 2022-09-07-13:35
 */
public class Solution {

    public String reorderSpaces(String text) {
        int spaceCnt = 0;
        List<String> list = new ArrayList<> ();
        StringBuilder sb = new StringBuilder ();
        for (char c : text.toCharArray ()) {
            if (c == ' ') {
                spaceCnt++;
                if (sb.length () > 0) {
                    list.add (sb.toString ());
                }
                sb.delete (0, sb.length ());
            } else {
                sb.append (c);
            }
        }
        if (sb.length () > 0) {
            list.add (sb.toString ());
        }
        int tmp = list.size () > 0 ? spaceCnt / (list.size () - 1) : 0;
        sb = new StringBuilder ();
        for (String str : list) {
            sb.append (str);
            for (int i = 0; spaceCnt > 0 && i < tmp; i++) {
                sb.append (" ");
                spaceCnt--;
            }
        }
        while (spaceCnt-- > 0) {
            sb.append (" ");
        }

        return sb.toString ();
    }
}

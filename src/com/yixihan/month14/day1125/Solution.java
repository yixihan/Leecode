package com.yixihan.month14.day1125;

/**
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。
 * 我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * <p>
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
 * 扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * <p>
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。
 * 此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。
 * 如果 S = "helllllooo"，那么查询词 "hello" 是可扩张的，
 * 因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = S。
 * <p>
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * <p>
 * 输入：
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 *
 * @author yixihan
 * @date 2022/11/25 9:05
 */
public class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            ans += checkvalid (s, word) ? 1 : 0;
        }

        return ans;
    }

    private boolean checkvalid(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length () && j < word.length ()) {
            if (s.charAt (i) == word.charAt (j)) {
                int counti = 1;
                int countj = 1;
                while (i + 1 < s.length () && s.charAt (i + 1) == s.charAt (i)) {
                    i++;
                    counti++;
                }
                while (j + 1 < word.length () && word.charAt (j + 1) == word.charAt (j)) {
                    j++;
                    countj++;
                }
                if (counti == countj || (counti > countj && counti > 2)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (i == s.length () && j == word.length ()) {
            return true;
        } else {
            return false;
        }

    }

}

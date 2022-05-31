package com.yixihan.month08.day0531;

/**
 * 现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。
 * <p>
 * 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
 * <p>
 * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
 * <p>
 * 字符串 s 字典顺序小于 字符串 t 有两种情况：
 * <p>
 * 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。
 * 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
 * <p>
 * 输入：words = ["wrt","wrf","er","ett","rftt"]
 * 输出："wertf"
 * <p>
 * 输入：words = ["z","x"]
 * 输出："zx"
 * <p>
 * 输入：words = ["z","x","z"]
 * 输出：""
 * 解释：不存在合法字母顺序，因此返回 "" 。
 *
 * @author : yixihan
 * @create : 2022-05-31-8:32
 */
public class Solution {
    public String alienOrder(String[] words) {
        int[] degree = new int[26];
        Map<Character, List<Character>> graph = new HashMap<> ();
        int n = words.length;
        for (String word : words) {
            for (int j = 0; j < word.length (); j++) {
                graph.putIfAbsent (word.charAt (j), new ArrayList<> ());
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int t = Math.min (w1.length (), w2.length ());
            boolean find = false;
            for (int j = 0; j < t; j++) {
                if (w1.charAt (j) != w2.charAt (j)) {
                    char c1 = w1.charAt (j);
                    char c2 = w2.charAt (j);
                    graph.get (c1).add (c2);
                    degree[c2 - 'a']++;
                    find = true;
                    break;
                }
            }

            if (!find && w1.length () > w2.length ()) return "";
        }

        StringBuilder sb = new StringBuilder ();
        Queue<Integer> queue = new LinkedList<> ();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0 && graph.containsKey ((char) (i + 'a'))) {
                queue.offer (i);
            }
        }

        while (!queue.isEmpty ()) {
            int pos = queue.poll ();
            char c = (char) (pos + 'a');
            sb.append (c);
            if (!graph.containsKey (c)) continue;
            for (Character next : graph.get (c)) {
                degree[next - 'a']--;
                if (degree[next - 'a'] == 0) {
                    queue.offer (next - 'a');
                }
            }
        }
        return sb.length () < graph.size () ? "" : sb.toString ();
    }
}

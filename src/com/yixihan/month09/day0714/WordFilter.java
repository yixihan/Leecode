package com.yixihan.month09.day0714;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 * <p>
 * 实现 WordFilter 类：
 * <p>
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。
 * 如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 * <p>
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
 *
 * @author : yixihan
 * @create : 2022-07-14-8:56
 */
public class WordFilter {
    Trie prefixTree;
    Trie suffixTree;

    public WordFilter(String[] words) {
        prefixTree = new Trie ();
        suffixTree = new Trie ();
        for (int i = 0; i < words.length; i++) {
            prefixTree.insertNode (words[i], i);
            //翻转字符串
            String reverseStr = new StringBuilder (words[i]).reverse ().toString ();
            suffixTree.insertNode (reverseStr, i);
        }
    }

    public int f(String prefix, String suffix) {
        suffix = new StringBuilder (suffix).reverse ().toString ();

        List<Integer> prefixList;
        List<Integer> suffixList;

        //获取满足前缀的字符串列表
        prefixList = prefixTree.search (prefix);
        //获取满足后缀的字符串列表
        suffixList = suffixTree.search (suffix);
        int prefixLen = prefixList.size ();
        int suffixLen = suffixList.size ();
        if (prefixLen == 0 || suffixLen == 0) {
            return -1;
        }
        //寻找最大交集 list是单调递增的 从后向前匹配即可
        int i = prefixLen - 1;
        int j = suffixLen - 1;
        while (i >= 0 && j >= 0) {
            int prefixIndex = prefixList.get (i);
            int suffixIndex = suffixList.get (j);
            if (prefixIndex == suffixIndex) {
                return prefixIndex;
            } else if (prefixIndex > suffixIndex) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    class TrieNode {
        List<Integer> index;
        TrieNode[] child;

        public TrieNode() {
            index = new ArrayList<> ();
            child = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode ();
        }

        /**
         * 向字典树中插入单词和其索引
         *
         * @param word  单词
         * @param index 索引
         */
        public void insertNode(String word, int index) {
            TrieNode cur = root;
            cur.index.add (index);
            char[] chars = word.toCharArray ();
            for (char aChar : chars) {
                if (cur.child[aChar - 'a'] == null) {
                    cur.child[aChar - 'a'] = new TrieNode ();
                }
                cur = cur.child[aChar - 'a'];
                cur.index.add (index);
            }
        }

        /**
         * 查找前缀 若存在返回索引 不存在返回空list
         *
         * @param word 单词
         */
        public List<Integer> search(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray ();
            for (char aChar : chars) {
                if (cur.child[aChar - 'a'] == null) {
                    return new ArrayList<> ();
                }
                cur = cur.child[aChar - 'a'];
            }
            return cur.index;
        }
    }


}

package com.yixihan.offer.day29;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * @author : yixihan
 * @create : 2022-03-20-10:52
 */
public class Permutation {

    char[] chars;
    Set<String> list;
    boolean[] visited;

    /**
     * 用visited记录一下每次已经访问过的char，然后每次for loop 都从头开始，遇到visited直接跳过就可以。
     */
    public String[] permutation(String s) {
        chars = s.toCharArray ();
        list = new HashSet<> ();
        visited = new boolean[chars.length];
        dfs ("");
        return list.toArray (new String[0]);
    }

    private void dfs(String s) {
        if (s.length () == chars.length) {
            list.add (s);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs (s + String.valueOf (chars[i]));
            visited[i] = false;
        }
    }
}

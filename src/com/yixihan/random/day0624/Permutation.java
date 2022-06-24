package com.yixihan.random.day0624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * <p>
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 *
 * @author : yixihan
 * @create : 2022-06-24-9:27
 */
public class Permutation {

    List<String> list = new ArrayList<> ();

    public String[] permutation(String S) {

        char[] arr = S.toCharArray ();
        Arrays.sort (arr);
        boolean[] visited = new boolean[arr.length];

        helper (new StringBuilder (), visited, arr);

        return list.toArray (new String[0]);
    }

    private void helper(StringBuilder sb, boolean[] visited, char[] arr) {
        if (sb.length () == arr.length) {
            list.add (sb.toString ());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                if (i <= 0 || arr[i] != arr[i - 1] || visited[i - 1]) {
                    sb.append (arr[i]);
                    visited[i] = true;
                    helper (sb, visited, arr);
                    visited[i] = false;
                    sb.deleteCharAt (sb.length () - 1);
                }
            }
        }
    }
}

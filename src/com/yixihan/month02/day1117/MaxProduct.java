package com.yixihan.month02.day1117;

/**
 * @author : yixihan
 * @create : 2021-11-17-13:27
 */
public class MaxProduct {

    /**
     * 位运算暴力匹配
     */
    public int maxProduct(String[] words) {

        int n = words.length;
        int ans = 0;
        boolean flag;

        // 记录每个字符串
        char[][] t = new char[n][];

        // 记录每个字符串的每个字母的出现次数
        int[][] k = new int[n][26];

        for (int i = 0; i < n; i ++) {
            t[i] = words[i].toCharArray();
            for (int j = 0; j < words[i].length(); j ++) {
                k[i][words[i].charAt(j) - 'a']++;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                flag = true;
                for (int p = 0;p < words[j].length();p ++) {
                    if (k[i][t[j][p] - 'a'] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}

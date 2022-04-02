package com.yixihan.weekly_competition.week285;

/**
 * @author : yixihan
 * @create : 2022-03-27-0:08
 */
public class LongestRepeating {

    /**
     * 此方法超时, 需要用线段树, 不懂
     * @param s
     * @param queryCharacters
     * @param queryIndices
     * @return
     */
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = queryIndices.length;
        int[] ans = new int[n];
        char[] arr = s.toCharArray ();
        char[] replace = queryCharacters.toCharArray ();

        for (int i = 0; i < n; i++) {
            arr[queryIndices[i]] = replace[i];
            ans[i] = getMaxSize (arr);
        }

        return ans;

    }

    private int getMaxSize (char[] arr) {
        int ans = 1;
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                ans = Math.max (count, ans);
                count = 0;
            }
        }

        return ans;
    }
}

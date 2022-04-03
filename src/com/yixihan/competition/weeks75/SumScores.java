package com.yixihan.competition.weeks75;

/**
 * @author : yixihan
 * @create : 2022-04-03-0:26
 */
public class SumScores {
    public long sumScores(String s) {
        int[] z = new int[s.length ()];
        for (int i = 0, x = 0, y = 0; i < s.length (); i++) {
            for (z[i] = Math.max (0, Math.min (z[i - x], y - i + 1)); i + z[i] < s.length () && s.charAt (z[i]) == s.charAt (i + z[i]); y = i + z[x = i]++) {
            }
        }
        long sum = 0;
        for (int i : z) {
            sum += i;
        }
        return sum;
    }
}

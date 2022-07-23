package com.yixihan.random.day0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : yixihan
 * @create : 2022-07-23-15:15
 */
public class getMaxScore {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        String[] split = br.readLine ().split (" ");
        String[] s = br.readLine ().split (" ");
        int n = Integer.parseInt (split[0]);
        int m = Integer.parseInt (split[1]);
        int[] scores = new int[n];
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt (s[i]);
            maxScore = Math.max (maxScore, scores[i]);
        }

        for (int i = 0; i < m; i++) {
            String[] instruction = br.readLine ().split (" ");
            if ("Q".equals (instruction[0])) {
                System.out.println (maxScore);
            } else if ("U".equals (instruction[0])) {
                scores[Integer.parseInt (instruction[1]) - 1] = Integer.parseInt (instruction[2]);
                maxScore = Math.max (maxScore, scores[Integer.parseInt (instruction[1]) - 1]);
            } else {
                throw new RuntimeException ();
            }
        }

    }
}
package com.yixihan.competition.winner3.interest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : yixihan
 * @create : 2022-03-27-11:24
 */
public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader (inputStream);
        int start = in.nextInt ();
        int n = in.nextInt ();

        int ans = getAns (start, n);
        System.out.println (ans);
    }

    private static int getAns(int start, int n) {
        int ans = start;

        for (int i = 0; i < n; i++) {
            int interest = ans / 10;
            interest = Math.min (interest, 5);
            ans += interest + 5;
        }

        return ans;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader (stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer (reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

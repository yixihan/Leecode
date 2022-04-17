package com.yixihan.competition.winner3.mp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : yixihan
 * @create : 2022-03-27-11:36
 */
public class Main {

    static int count = 0;
    static int n = 0;
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader (inputStream);
        n = in.nextInt ();
        
        dfs (1);
    }

    private static void dfs(int x) {
        System.out.println (x + ".mp4");
        count++;
        if (count >= 50) {
            System.exit (0);
        }
        if (x * 10 <= n) {
            dfs (x * 10);
        }
        if (x + 1 <= n && x / 10 == (x + 1) / 10) {
            dfs (x + 1);
        }
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

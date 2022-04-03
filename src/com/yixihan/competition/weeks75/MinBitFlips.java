package com.yixihan.competition.weeks75;

import java.util.Arrays;

/**
 * @author : yixihan
 * @create : 2022-04-02-22:31
 */
public class MinBitFlips {
    public int minBitFlips(int start, int goal) {

        int val = start ^ goal;
        return Integer.bitCount (val);
    }
}

class Main {
    public static void main(String[] args) {
        MinBitFlips test = new MinBitFlips ();
        System.out.println (test.minBitFlips (10, 7));
        System.out.println (test.minBitFlips (3, 4));
    }
}
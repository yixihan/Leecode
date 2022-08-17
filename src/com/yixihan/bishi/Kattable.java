package com.yixihan.bishi;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : yixihan
 * @create : 2022-08-16-15:08
 */
public class Kattable {

    public static void main(String[] args) {

    }

    class Solution {

        final char[] hoolers = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        public String isKattable (String str) {

            StringBuilder sb = new StringBuilder ();

            for (char hooler : hoolers) {
                if (verify (str + hooler)) {
                    sb.append (hooler);
                }
            }

            
            return sb.toString ();
        }

        private boolean verify (String kattable) {
            char[] arr = kattable.toCharArray ();
            int[] letters = new int[17];
            int triple = 0;
            int straight = 0;
            int pair = 0;

            for (char c : arr) {
                if (c >= 'a' && c <= 'h') {
                    letters[c - 'a']++;
                } else if (c >= 'A' && c <= 'H') {
                    letters[c - 'A' + 8]++;
                } else {
                    letters[16]++;
                }
            }


            return pair == 1 && triple + straight == 3;
        }
    }
}

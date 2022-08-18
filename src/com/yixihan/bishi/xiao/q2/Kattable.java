package com.yixihan.bishi.xiao.q2;

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

            for (int i = 1; i < 7; i++) {
                if (letters[i - 1] > 0 && letters[i] > 0 && letters[i + 1] > 0) {
                    int min = min (letters[i - 1], letters[i], letters[i + 1]);
                    straight += min;
                    letters[i - 1] -= min;
                    letters[i] -= min;
                    letters[i + 1] -= min;
                }
                if (letters[16] > 0 ) {

                }
            }

            for (int i = 9; i < 15; i++) {

            }


            return pair == 1 && triple + straight == 3;
        }

        private int min (int num1, int num2, int num3) {
            return Math.min (num1, Math.min (num2, num3));
        }
    }
}

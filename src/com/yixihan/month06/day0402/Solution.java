package com.yixihan.month06.day0402;

/**
 * @author : yixihan
 * @create : 2022-04-02-11:35
 */
public class Solution {
    public int strongPasswordChecker(String password) {
        char[] pass = password.toCharArray ();
        int n = pass.length;
        int A = 0;
        int B = 0;
        int C = 0;

        for (char val : pass) {
            if (val >= 'a' && val <= 'z') {
                A = 1;
            } else if (val >= '0' && val <= '9') {
                B = 1;
            } else if (val >= 'A' && val <= 'Z') {
                C = 1;
            }
        }

        int m = A + B + C;

        if (n < 6) {
            return Math.max (6 - n, 3 - m);
        }
        if (n <= 20) {
            int tot = 0;

            for (int i = 0; i < n; ) {
                int j = i;

                while (j < n && pass[j] == pass[i]) {
                    j++;
                }

                int cnt = j - i;
                if (cnt >= 3) {
                    tot += cnt / 3;
                }
                i = j;
            }
            return Math.max (tot, 3 - m);
        }

        int tot = 0;
        int[] cnts = new int[3];

        for (int i = 0; i < n; ) {
            int j = i;

            while (j < n && pass[j] == pass[i]) {
                j++;
            }

            int cnt = j - i;
            if (cnt >= 3) {
                tot += cnt / 3;
                cnts[cnt % 3]++;
            }
            i = j;
        }

        int base = n - 20;
        int cur = base;

        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                cnts[i] = tot;
            }
            if (cnts[i] != 0 && cur != 0) {
                int t = Math.min (cnts[i] * (i + 1), cur);
                cur -= t;
                tot -= t / (i + 1);
            }
        }

        return base + Math.max (tot, 3 - m);
    }
}

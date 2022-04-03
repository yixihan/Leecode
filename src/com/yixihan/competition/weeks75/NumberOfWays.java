package com.yixihan.competition.weeks75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-04-02-22:46
 */
public class NumberOfWays {

    public long numberOfWays(String s) {
        int ans = 0;
        char[] arr = s.toCharArray ();
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        int countZ = 0;
        int countO = 0;

        for (int i = n - 1; i >= 0; i--) {
            list.add (new int[]{i, arr[i] - '0', countZ, countO});
            if (arr[i] == '1') {
                countO++;
            } else {
                countZ++;
            }
        }

        for (int[] temp : list) {
            System.out.println (Arrays.toString (temp));
        }

        return ans;
    }

    static class Main {
        public static void main(String[] args) {
            System.out.println (new NumberOfWays ().numberOfWays ("001101"));
        }
    }
}

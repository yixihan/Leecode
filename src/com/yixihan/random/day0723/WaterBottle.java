package com.yixihan.random.day0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-07-23-14:54
 */
public class WaterBottle {

    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        List<Integer> list = new ArrayList<>(10);
        int n;
        while ((n = Integer.parseInt (br.readLine ())) != 0) {
            list.add (n);
        }


        for (int val : list) {
            System.out.println (helper (val));
        }

    }

    private static int helper(int val) {
        int cnt = 0;

        while (val >= 3) {
            cnt += val / 3;
            val = val / 3 + val % 3;
        }

        return val == 2 ? cnt + 1 : cnt;
    }
}

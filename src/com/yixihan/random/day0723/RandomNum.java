package com.yixihan.random.day0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * @author : yixihan
 * @create : 2022-07-23-15:03
 */
public class RandomNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int n = Integer.parseInt (br.readLine ());
        TreeSet<Integer> set = new TreeSet<> ();

        for (int i = 0; i < n; i++) {
            set.add (Integer.parseInt (br.readLine ()));
        }

        for (int val : set) {
            System.out.println (val);
        }

    }
}

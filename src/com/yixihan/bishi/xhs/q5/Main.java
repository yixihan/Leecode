package com.yixihan.bishi.xhs.q5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-09-04-15:58
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        List<Integer> list = new ArrayList<> (n);

        for (int i = 0; i < n; i++) {
            list.add (sc.nextInt ());
        }

        System.out.println (helper (list));
    }

    private static int helper(List<Integer> list) {
        list.sort ((o1, o2) -> Math.abs (o2) - Math.abs (o1));
        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < list.size (); i++) {
            if (list.get (i) > 0) {
                if (i == 0) {
                    ans += Math.abs (7 - list.get (i));
                } else {
                    ans += Math.abs (1 - list.get (i));
                }
            } else if (list.get (i) < 0) {
                if (i == 0) {
                    ans += Math.abs (-7 - list.get (i));
                } else {
                    ans += Math.abs (-1 - list.get (i));
                }
                cnt++;
            } else {
                if (cnt % 2 != 0) {
                    cnt++;
                }
                ans++;
            }
        }

        return cnt % 2 == 0 ? ans : ans + 2;
    }
}

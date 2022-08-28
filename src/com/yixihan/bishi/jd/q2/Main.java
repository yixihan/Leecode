package com.yixihan.bishi.jd.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-27-19:18
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();

        Map<Integer, Integer> map1 = new HashMap<> ();
        Map<Integer, Integer> map2 = new HashMap<> ();

        for (int i = 0; i < n; i++) {
            int key = sc.nextInt ();
            if (i % 2 == 0) {
                map1.put (key, map1.getOrDefault (key, 0) + 1);
            } else {
                map2.put (key, map2.getOrDefault (key, 0) + 1);
            }
        }
        int ans = 0;
        int maxKey1 = getMax (map1, -1);
        int maxKey2 = getMax (map2, -1);

        if (maxKey1 == maxKey2) {
            if (map1.get (maxKey1) > map2.get (maxKey2)) {
                ans = getCnt (map1, maxKey1) + getCnt (map2, getMax (map2, maxKey2));
            } else {
                ans = getCnt (map1, getMax (map1, maxKey1)) + getCnt (map2, maxKey2);
            }
        } else {
            ans = getCnt (map1, maxKey1) + getCnt (map2, maxKey2);
        }

        System.out.println (ans);
    }

    private static int getCnt(Map<Integer, Integer> map, int maxKey) {
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
            cnt += entry.getValue ();
        }

        return cnt - map.get (maxKey);
    }

    private static int getMax(Map<Integer, Integer> map, int excludeKey) {
        int max = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
            if (excludeKey != entry.getKey () && max < entry.getValue ()) {
                max = entry.getValue ();
                maxKey = entry.getKey ();
            }
        }

        return maxKey;
    }
}

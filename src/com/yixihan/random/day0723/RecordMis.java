package com.yixihan.random.day0723;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-07-23-15:29
 */
public class RecordMis {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<> ();

        while (sc.hasNextLine ()) {
            String mis = sc.nextLine ();
            String key = mis.substring (mis.lastIndexOf ("\\") + 1);
            map.put (key, map.getOrDefault (key, 0) + 1);
        }
        sc.close ();

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet ()) {
            if (cnt++ >= 8) {
                break;
            }

            String key = entry.getKey ();
            if (key.length () > 16) {
                key = key.substring (key.length () - 16);
            }

            System.out.println (key + " " + entry.getValue ());
        }

    }
}

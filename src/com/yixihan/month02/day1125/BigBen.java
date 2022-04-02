package com.yixihan.month02.day1125;

import java.util.Arrays;

/**
 * 童年经典, 敲笨钟
 * @author : yixihan
 * @create : 2021-11-25-21:03
 */
public class BigBen {

    public void bigBen (String[] arrays) {

        for (String array : arrays) {

            String[] split = array.split(" ");

            String val1 = split[split.length / 2 - 1];
            String val2 = split[split.length - 1];

            if ("ong".equals(val1.substring(val1.length() - 4, val1.length() - 1))
                    && "ong".equals(val2.substring(val2.length() - 4, val2.length() - 1))) {

                for (int i = 0; i < split.length - 3; i++) {
                    System.out.print(split[i] + " ");
                }
                System.out.println("qiao ben zhong.");

            } else {
                System.out.println("skipped");
            }
        }
    }
}

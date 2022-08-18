package com.yixihan.bishi.cvte.q1;

import java.io.*;
import java.util.Arrays;

/**
 * @author : yixihan
 * @create : 2022-08-17-18:36
 */
public class Main {


    public static Object statisticAge(String filePath) throws IOException {
        int[] ages = new int[111];
        FileInputStream fis = new FileInputStream (filePath);
        byte[] buffer = new byte[1024];
        StringBuilder sb = new StringBuilder ();
        int len;
        while ((len = fis.read (buffer)) != -1) {
            sb.append (new String(buffer, 0, len));
            int index = sb.lastIndexOf (",");
            String value = sb.substring (0, index);
            sb = new StringBuilder (sb.substring (index));

            for (String val : value.split (",")) {
                ages[Integer.parseInt (val)]++;
            }
        }

        return ages;
    }

    public static void main(String[] args) {
        try {
            int[] o = (int[])statisticAge ("D:\\秋招\\test.txt");
            System.out.println (Arrays.toString (o));
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}

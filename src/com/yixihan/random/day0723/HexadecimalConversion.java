package com.yixihan.random.day0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : yixihan
 * @create : 2022-07-23-15:06
 */
public class HexadecimalConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        //        String str = br.readLine ().substring (2).toLowerCase();

        System.out.println (Integer.parseInt (br.readLine ().substring (2).toLowerCase (), 16));

    }
}

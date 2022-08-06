package com.yixihan.bishi.meituan.q5;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-08-06-10:59
 */
public class Main {

    /*
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
    MeiTuannauTieMwowwow
MeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwow20
MeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwowMeiTuannauTieMwowwow20

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int index = sc.nextInt();
            System.out.println ("MeiTuannauTieMwowwow".charAt ((index - 1) % 20));
        }
    }


}

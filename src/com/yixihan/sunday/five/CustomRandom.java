package com.yixihan.sunday.five;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yixihan
 * @date 2022-10-31-8:59
 */
public class CustomRandom {

    @Test
    public void testRandom() {
        getRandom (1, 16, 8);
        getRandom (17, 36, 9);
    }


    public void getRandom(int start, int end, int len) {
        List<Integer> list1 = new ArrayList<> ();
        List<Integer> list2 = new ArrayList<> ();
        Random rd = new Random();

        for (int i = start; i <= end; i++) {
            if (rd.nextBoolean () && list1.size () <= len) {
                list1.add (i);
            } else {
                list2.add (i);
            }
        }

        System.out.println ("list1 : " + list1);
        System.out.println ("list2 : " + list2);
    }
}

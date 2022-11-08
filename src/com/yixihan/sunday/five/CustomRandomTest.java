package com.yixihan.sunday.five;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yixihan
 * @date 2022-10-31-8:59
 */
public class CustomRandomTest {

    @Test
    public void testRandom() {
        getRandom (1, 16, 4);
        getRandom (17, 36, 4);
    }


    public void getRandom(int start, int end, int group) {
        int len = (end - start + 1) / group;
        Random rd = new Random ();
        List<List<Integer>> list = new ArrayList<> ();
        for (int i = 0; i < group; i++) {
            list.add (new ArrayList<> ());
        }

        for (int i = start; i <= end; i++) {
            int index = rd.nextInt (1000) % 4;
            if (list.get (index).size () < len) {
                list.get (index).add (i);
            } else {
                i--;
            }
        }

        for (int i = 0; i < group; i++) {
            System.out.println ("group [" + i + "] : " + list.get (i));
        }
    }
}

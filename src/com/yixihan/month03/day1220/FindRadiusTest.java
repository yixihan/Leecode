package com.yixihan.month03.day1220;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-20-0:06
 */
class FindRadiusTest {

    FindRadius test = new FindRadius ();

    @Test
    void findRadius() {

        int[] houses = {1,1,1,1,1,1,999,999,999,999,999};
        int[] heaters = {499,500,501};
        System.out.println (test.findRadius (houses, heaters));
    }
}
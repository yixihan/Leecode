package com.yixihan.month03.day1224;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-24-0:21
 */
class EatenApplesTest {

    EatenApples test = new EatenApples ();

    @Test
    void eatenApples1() {
        int[] apples = {1,2,3,5,2};
        int[] days = {3,2,1,4,2};
        System.out.println (test.eatenApples2 (apples, days));
    }

    @Test
    void eatenApples2() {
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};
        System.out.println (test.eatenApples2 (apples, days));
    }
}
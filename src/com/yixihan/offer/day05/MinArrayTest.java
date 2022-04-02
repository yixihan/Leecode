package com.yixihan.offer.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-25-13:50
 */
class MinArrayTest {

    @Test
    void minArray1() {
        int[] num = {3,4,5,1,2};
        System.out.println (new MinArray ().minArray (num));
    }

    @Test
    void minArray2() {
        int[] num = {2,2,2,0,1};
        System.out.println (new MinArray ().minArray (num));
    }
}
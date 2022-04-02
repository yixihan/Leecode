package com.yixihan.month03.day0109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-09-7:14
 */
class SlowestKeyTest {

    SlowestKey test = new SlowestKey ();

    @Test
    void slowestKey1() {
        int[] releaseTimes = {9,29,49,50};

        System.out.println (test.slowestKey (releaseTimes, "cbcd"));
    }

    @Test
    void slowestKey2() {
        int[] releaseTimes = {12,23,36,46,62};

        System.out.println (test.slowestKey (releaseTimes, "spuda"));
    }

    @Test
    void slowestKey3() {
        int[] releaseTimes = {23,34,43,59,62,80,83,92,97};

        System.out.println (test.slowestKey (releaseTimes, "qgkzzihfc"));
    }


    @Test
    void slowestKey4() {
        int[] releaseTimes = {19,22,28,29,66,81,93,97};

        System.out.println (test.slowestKey (releaseTimes, "fnfaaxha"));
    }
}
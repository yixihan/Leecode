package com.yixihan.month04.day0126;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-26-8:45
 */
class DetectSquaresTest {

    DetectSquares test = new DetectSquares ();

    @Test
    void count() {
        test.add (new int[]{3, 10});
        test.add (new int[]{11, 2});
        test.add (new int[]{3, 2});

        System.out.println (test.count (new int[]{11, 10}));
        System.out.println (test.count (new int[]{14, 8}));

        test.add (new int[]{11, 2});

        System.out.println (test.count (new int[]{11, 10}));
    }
}
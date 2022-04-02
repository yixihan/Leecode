package com.yixihan.month04.day0204;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-04-9:07
 */
class SolutionTest {

    @Test
    void countGoodRectangles() {
        int[][] rectangles = {{5,8},{3,9},{5,12},{16,5}};

        System.out.println (new Solution ().countGoodRectangles (rectangles));
    }
}
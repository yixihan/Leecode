package com.yixihan.offer.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-01-12:46
 */
class MaxValueTest {

    @Test
    void maxValue() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println (new MaxValue ().maxValue (grid));
    }
}
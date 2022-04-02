package com.yixihan.month04.day0129;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-29-9:41
 */
class HighestPeakTest {

    @Test
    void highestPeak() {
        int[][] isWater = new int[][]{{0,0,1},{1,0,0},{0,0,0}};
        int[][] val = new HighestPeak ().highestPeak (isWater);

        for (int[] ints : val) {
            System.out.println (Arrays.toString (ints));
        }
    }
}
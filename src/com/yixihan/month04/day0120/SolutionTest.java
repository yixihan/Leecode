package com.yixihan.month04.day0120;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-20-7:03
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void stoneGameIX() {

        int[] stones = {5,1,2,4,3};

        System.out.println (test.stoneGameIX (stones));
    }
}
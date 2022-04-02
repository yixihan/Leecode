package com.yixihan.offer.day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-28-13:01
 */
class NumWaysTest {

    @Test
    void numWays() {
        NumWays ways = new NumWays ();

        System.out.println (ways.numWays (0));
        System.out.println (ways.numWays (1));
        System.out.println (ways.numWays (2));
        System.out.println (ways.numWays (3));
        System.out.println (ways.numWays (4));
    }
}
package com.yixihan.month04.day0207;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-07-12:47
 */
class SolutionTest {

    @Test
    void longestDiverseString() {
        System.out.println (new Solution ().longestDiverseString (2, 2, 1));
        System.out.println (new Solution ().longestDiverseString (1, 1, 7));
        System.out.println (new Solution ().longestDiverseString (7, 1, 0));
    }
}
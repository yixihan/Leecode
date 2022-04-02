package com.yixihan.month05.day0217;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-17-6:58
 */
class SolutionTest {

    @Test
    void knightProbability() {
        System.out.println (new Solution ().knightProbability (3, 2, 0, 0));
        System.out.println (new Solution ().knightProbability (1, 1, 0, 0));
    }
}
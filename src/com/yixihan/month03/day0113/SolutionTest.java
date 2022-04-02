package com.yixihan.month03.day0113;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-13-6:47
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void dominantIndex() {
        int[] nums = {0, 0, 0, 1};

        System.out.println (test.dominantIndex (nums));
    }
}
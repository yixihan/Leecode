package com.yixihan.month05.day0304;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-04-12:54
 */
class SolutionTest {

    @Test
    void subArrayRanges1() {
        int[] nums = {1, 2, 3};
        System.out.println (new Solution ().subArrayRanges (nums));
    }

    @Test
    void subArrayRanges2() {
        int[] nums = {4,-2,-3,4,1};
        System.out.println (new Solution ().subArrayRanges (nums));
    }
}
package com.yixihan.month02.day1203;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-03-13:00
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void largestSumAfterKNegations() {

        int[] arr = {3,-1,0,2};

        System.out.println (test.largestSumAfterKNegations (arr, 3));
        System.out.println (test.largestSumAfterKNegations1 (arr, 3));
    }
}
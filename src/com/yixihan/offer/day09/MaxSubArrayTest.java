package com.yixihan.offer.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-01-12:33
 */
class MaxSubArrayTest {

    @Test
    void maxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println (new MaxSubArray ().maxSubArray (nums));
    }
}
package com.yixihan.month03.day0112;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-01-12-6:35
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void increasingTriplet1() {
        int[] nums = {9,10,5,11,10,9,8};
        System.out.println (test.increasingTriplet (nums));

    }

    @Test
    void increasingTriplet2() {
        int[] nums = {20,100,10,12,5,13};
        System.out.println (test.increasingTriplet (nums));
    }

    @Test
    void increasingTriplet3() {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println (test.increasingTriplet (nums));
    }
}
package com.yixihan.month03.day1229;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-29-14:58
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void countQuadruplets1() {
        int[] num = {1,1,1,3,5};
        System.out.println (test.countQuadruplets (num));
    }

    @Test
    void countQuadruplets2() {
        int[] num = {3,3,6,4,5};
        System.out.println (test.countQuadruplets (num));
    }

    @Test
    void countQuadruplets3() {
        int[] num = {1,2,3,6};
        System.out.println (test.countQuadruplets (num));
    }
}
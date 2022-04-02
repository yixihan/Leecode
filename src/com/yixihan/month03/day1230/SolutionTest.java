package com.yixihan.month03.day1230;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-30-16:50
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void isNStraightHand1() {

        int[] hand = {1,2,3,6,2,3,4,7,8};

        System.out.println (test.isNStraightHand (hand, 3));
    }

    @Test
    void isNStraightHand2() {

        int[] hand = {1,2,3,4,5};

        System.out.println (test.isNStraightHand (hand, 4));
    }
}
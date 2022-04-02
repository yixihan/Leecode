package com.yixihan.month03.day0103;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-03-14:38
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void dayOfTheWeek1() {
        System.out.println (test.dayOfTheWeek (31, 8, 2019));
    }

    @Test
    void dayOfTheWeek2() {
        System.out.println (test.dayOfTheWeek (18, 7, 1999));
    }

    @Test
    void dayOfTheWeek3() {
        System.out.println (test.dayOfTheWeek (15, 8, 1993));
    }

    @Test
    void dayOfTheWeek4() {
        System.out.println (test.dayOfTheWeek (3, 1, 2022));
    }
}
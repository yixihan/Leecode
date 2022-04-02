package com.yixihan.month03.day1231;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-31-17:24
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void checkPerfectNumber1() {
        System.out.println (test.checkPerfectNumber (28));
    }

    @Test
    void checkPerfectNumber2() {
        System.out.println (test.checkPerfectNumber (6));
    }

    @Test
    void checkPerfectNumber3() {
        System.out.println (test.checkPerfectNumber (496));
    }

    @Test
    void checkPerfectNumber4() {
        System.out.println (test.checkPerfectNumber (8128));
    }

    @Test
    void checkPerfectNumber5() {
        System.out.println (test.checkPerfectNumber (2));
    }
}
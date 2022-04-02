package com.yixihan.month03.day0110;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-10-6:46
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void isAdditiveNumber1() {
        Assertions.assertTrue (test.isAdditiveNumber ("112358"));
    }

    @Test
    void isAdditiveNumber2() {
        Assertions.assertTrue (test.isAdditiveNumber ("199100199"));
    }

    @Test
    void isAdditiveNumber3() {
        Assertions.assertFalse (test.isAdditiveNumber ("199001200"));
    }
}
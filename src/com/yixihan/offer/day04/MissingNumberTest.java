package com.yixihan.offer.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-24-14:10
 */
class MissingNumberTest {

    @Test
    void missingNumber1() {
        int[] nums = {0, 1, 3};

        System.out.println (new MissingNumber ().missingNumber (nums));
    }

    @Test
    void missingNumber2() {
        int[] nums = {0,1,2,3,4,5,6,7,9};

        System.out.println (new MissingNumber ().missingNumber (nums));
    }

    @Test
    void missingNumber3() {
        int[] nums = {0,1};

        System.out.println (new MissingNumber ().missingNumber (nums));
    }

    @Test
    void missingNumber4() {
        int[] nums = {0};

        System.out.println (new MissingNumber ().missingNumber (nums));
    }

    @Test
    void missingNumber5() {
        int[] nums = {1};

        System.out.println (new MissingNumber ().missingNumber (nums));
    }
}
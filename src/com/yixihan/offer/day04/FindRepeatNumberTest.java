package com.yixihan.offer.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-24-13:35
 */
class FindRepeatNumberTest {

    @Test
    void findRepeatNumber() {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};

        System.out.println (new FindRepeatNumber ().findRepeatNumber (arr));
    }
}
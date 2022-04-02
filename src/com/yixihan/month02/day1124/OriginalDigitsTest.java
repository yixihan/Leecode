package com.yixihan.month02.day1124;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-24-12:46
 */
class OriginalDigitsTest {

    OriginalDigits test = new OriginalDigits();

    @Test
    void originalDigits() {
        System.out.println(test.originalDigits("owoztneoer"));
        System.out.println(test.originalDigits("fviefuro"));
    }
}
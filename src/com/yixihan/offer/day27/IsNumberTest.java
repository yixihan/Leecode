package com.yixihan.offer.day27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-18-13:14
 */
class IsNumberTest {

    @Test
    void isNumber() {
        IsNumber test = new IsNumber ();

        System.out.println (test.isNumber ("2e+3"));
    }
}
package com.yixihan.month05.day0301;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-01-12:12
 */
class ConvertTest {

    @Test
    void convert1() {
        String ans = new Convert ().convert ("PAYPALISHIRING", 3);

        System.out.println (ans);

        assertEquals (ans, "PAHNAPLSIIGYIR");
    }

    @Test
    void convert2() {
        String ans = new Convert ().convert ("AB", 1);

        System.out.println (ans);

        assertEquals (ans, "AB");
    }
}
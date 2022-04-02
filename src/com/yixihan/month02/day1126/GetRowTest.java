package com.yixihan.month02.day1126;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-26-10:22
 */
class GetRowTest {

    GetRow test = new GetRow();

    @Test
    void getRow1() {
        System.out.println(test.getRow1(25));
    }

    @Test
    void getRow2() {
        System.out.println(test.getRow2(25));
    }

    @Test
    void getRow3() {
        System.out.println(test.getRow3(25));
    }
}
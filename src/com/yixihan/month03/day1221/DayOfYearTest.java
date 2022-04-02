package com.yixihan.month03.day1221;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-21-8:49
 */
class DayOfYearTest {

    DayOfYear test = new DayOfYear ();

    @Test
    void dayOfYear() {

        System.out.println (test.dayOfYear ("2012-01-02"));
    }
}
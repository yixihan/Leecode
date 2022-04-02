package com.yixihan.month04.day0131;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-31-11:43
 */
class NumberOfStepsTest {

    @Test
    void numberOfSteps() {
        System.out.println (new NumberOfSteps ().numberOfSteps (14));
        System.out.println (new NumberOfSteps ().numberOfSteps (8));
        System.out.println (new NumberOfSteps ().numberOfSteps (123));
    }
}
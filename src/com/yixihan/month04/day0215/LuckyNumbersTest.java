package com.yixihan.month04.day0215;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-15-7:04
 */
class LuckyNumbersTest {

    @Test
    void luckyNumbers() {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println (new LuckyNumbers ().luckyNumbers (matrix));
    }
}
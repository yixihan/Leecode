package com.yixihan.month02.day1125;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-25-13:06
 */
class MinAreaRectTest {

    MinAreaRect test = new MinAreaRect();

    @Test
    void minAreaRect() {
        int[][] arr = {{1,1},{1,3},{3,1},{3,3},{2,2}};

        System.out.println(test.minAreaRect(arr));
    }
}
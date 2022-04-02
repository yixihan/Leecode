package com.yixihan.month02.day1124;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-24-17:06
 */
class LongestOnesTest {

    LongestOnes test = new LongestOnes();

    @Test
    void longestOnes() {
        int[] arr1 = {1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1};
        System.out.println(test.longestOnes(arr1, 5));


    }
}
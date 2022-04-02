package com.yixihan.month05.day0219;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-19-8:50
 */
class PancakeSortTest {

    @Test
    void pancakeSort() {
        int[] arr = {3,2,4,1};
        System.out.println (new PancakeSort ().pancakeSort (arr));
    }
}
package com.yixihan.offer.day05;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-02-25-13:36
 */
class FindNumberIn2DArrayTest {

    @Test
    void findNumberIn2DArray() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println (new FindNumberIn2DArray ().findNumberIn2DArray (matrix, 14));
    }
}
package com.yixihan.month02.day1213;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-13-9:04
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void maxIncreaseKeepingSkyline() {
        int[][] grid = {{3,0,8,4}, {2,4,5,7}, {9,2,6,3}, {0,3,1,0}};
        System.out.println (test.maxIncreaseKeepingSkyline (grid));
    }
}
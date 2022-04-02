package com.yixihan.month04.day0212;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-12-13:46
 */
class SolutionTest {

    @Test
    void numEnclaves() {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};

        System.out.println (new Solution ().numEnclaves (grid));
    }
}
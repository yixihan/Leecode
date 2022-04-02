package com.yixihan.month04.day0205;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-05-9:21
 */
class SolutionTest {

    @Test
    void getMaximumGold() {
        Solution solution = new Solution ();
        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};

        System.out.println (solution.getMaximumGold (grid));
    }
}
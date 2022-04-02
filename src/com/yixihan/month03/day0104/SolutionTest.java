package com.yixihan.month03.day0104;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-04-0:44
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void catMouseGame() {

        int[][] graph = {{1,3},{0},{3},{0,2}};

        System.out.println (test.catMouseGame (graph));
    }
}
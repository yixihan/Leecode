package com.yixihan.month04.day0124;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-24-9:32
 */
class SecondMinimumTest {

    SecondMinimum test = new SecondMinimum ();

    @Test
    void secondMinimum() {

        int[][] edges = {{1,2},{1,3},{1,4},{3,4},{4,5}};

        System.out.println (test.secondMinimum (5, edges, 3, 5));
    }
}
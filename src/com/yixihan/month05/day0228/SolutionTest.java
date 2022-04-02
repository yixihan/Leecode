package com.yixihan.month05.day0228;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-28-12:42
 */
class SolutionTest {

    @Test
    void maximumRequests() {
        int[][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};

        System.out.println (new Solution ().maximumRequests (5, requests));
    }
}
package com.yixihan.month05.day0218;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-18-8:53
 */
class FindCenterTest {

    @Test
    void findCenter() {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println (new FindCenter ().findCenter (edges));
    }
}
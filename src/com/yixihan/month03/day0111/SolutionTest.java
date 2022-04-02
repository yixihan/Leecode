package com.yixihan.month03.day0111;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-01-11-6:54
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void isEscapePossible1() {
        int[][] blocked = {{0, 1}, {1, 0}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        System.out.println (test.isEscapePossible (blocked, source, target));
    }

    @Test
    void isEscapePossible2() {
        int[][] blocked = {};
        int[] source = {0, 0};
        int[] target = {999999, 999999};
        System.out.println (test.isEscapePossible (blocked, source, target));
    }
}
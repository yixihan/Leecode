package com.yixihan.month05.day0222;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-02-22-12:15
 */
class SolutionTest {

    @Test
    void numberOfGoodSubsets1() {
        int[] nums = {1, 2, 3, 4};

        System.out.println (new Solution ().numberOfGoodSubsets (nums));
    }

    @Test
    void numberOfGoodSubsets2() {
        int[] nums = {4, 2, 3, 15};

        System.out.println (new Solution ().numberOfGoodSubsets (nums));
    }

    @Test
    void numberOfGoodSubsets3() {
        int[] nums = {18,28,2,17,29,30,15,9,12};

        System.out.println (new Solution ().numberOfGoodSubsets (nums));
    }
}
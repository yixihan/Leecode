package com.yixihan.month03.day0114;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-14-7:00
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void kSmallestPairs() {
        int[] num1 = {1,7,11};
        int[] num2 = {2,4,6};
        int k = 3;

        List<List<Integer>> lists = test.kSmallestPairs (num1, num2, 9);

        System.out.println (lists);
    }
}
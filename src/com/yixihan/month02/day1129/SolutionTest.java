package com.yixihan.month02.day1129;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-29-13:50
 */
class SolutionTest {

    Solution test = new Solution();

    @Test
    void kthSmallestPrimeFraction() {

        int[] arr = {1, 2, 3, 5};

        int[] result = test.kthSmallestPrimeFraction(arr, 3);

        System.out.println(Arrays.toString(result));
    }
}
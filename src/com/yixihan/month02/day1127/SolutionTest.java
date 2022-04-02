package com.yixihan.month02.day1127;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-27-13:08
 */
class SolutionTest {



    @Test
    void flip() {
        Solution test = new Solution(3, 1);
        System.out.println(Arrays.toString(test.flip()));
        System.out.println(Arrays.toString(test.flip()));
        System.out.println(Arrays.toString(test.flip()));
        test.reset();
        System.out.println(Arrays.toString(test.flip()));

    }
}
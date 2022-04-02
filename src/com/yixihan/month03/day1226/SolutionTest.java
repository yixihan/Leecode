package com.yixihan.month03.day1226;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-26-0:18
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void findOcurrences() {

        String[] ocurrences = test.findOcurrences ("alice is a good girl she is a good student", "a", "good");

        System.out.println (Arrays.toString (ocurrences));
    }
}
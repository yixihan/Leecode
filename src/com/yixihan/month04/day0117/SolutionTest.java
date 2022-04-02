package com.yixihan.month04.day0117;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-17-6:45
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void countVowelPermutation() {

        System.out.println (test.countVowelPermutation (1));
        System.out.println (test.countVowelPermutation (2));
        System.out.println (test.countVowelPermutation (3));
        System.out.println (test.countVowelPermutation (4));
        System.out.println (test.countVowelPermutation (5));
    }
}
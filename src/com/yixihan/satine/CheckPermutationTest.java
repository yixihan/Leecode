package com.yixihan.satine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-03-17:17
 */
class CheckPermutationTest {

    @Test
    void checkPermutation() {
        System.out.println (new CheckPermutation ().CheckPermutation ("abc", "bca"));
        System.out.println (new CheckPermutation ().CheckPermutation ("abc", "bad"));
    }
}
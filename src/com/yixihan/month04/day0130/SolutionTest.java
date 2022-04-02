package com.yixihan.month04.day0130;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-30-9:37
 */
class SolutionTest {

    @Test
    void uncommonFromSentences() {

        System.out.println (Arrays.toString (new Solution ().uncommonFromSentences ("this apple is sweet", "this apple is sour")));
    }
}
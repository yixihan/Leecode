package com.yixihan.month05.day0223;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-23-12:53
 */
class SolutionTest {

    @Test
    void reverseOnlyLetters1() {
        String ans = new Solution ().reverseOnlyLetters ("ab-cd");

        assertEquals ("dc-ba", ans);
    }

    @Test
    void reverseOnlyLetters2() {
        String ans = new Solution ().reverseOnlyLetters ("7_28]");

        assertEquals ("7_28]", ans);
    }
}
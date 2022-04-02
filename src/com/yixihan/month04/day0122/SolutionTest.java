package com.yixihan.month04.day0122;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-01-22-12:50
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void removePalindromeSub() {
        System.out.println (test.removePalindromeSub ("ababa"));
        System.out.println (test.removePalindromeSub ("abb"));
        System.out.println (test.removePalindromeSub ("baabb"));
        System.out.println (test.removePalindromeSub ("aaabbaaa"));
    }
}
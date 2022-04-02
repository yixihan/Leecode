package com.yixihan.satine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-04-14:08
 */
class OneEditAwayTest {

    @Test
    void oneEditAway() {
        System.out.println (new OneEditAway ().oneEditAway ("pale", "ple"));
        System.out.println (new OneEditAway ().oneEditAway ("horse", "ros"));
        System.out.println (new OneEditAway ().oneEditAway ("abcdxabcde", "abcdeabcdx"));
        System.out.println (new OneEditAway ().oneEditAway ("ab", "bc"));
    }
}
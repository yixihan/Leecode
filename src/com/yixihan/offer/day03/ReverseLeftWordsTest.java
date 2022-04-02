package com.yixihan.offer.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-23-13:09
 */
class ReverseLeftWordsTest {

    @Test
    void reverseLeftWords1() {
        String words = new ReverseLeftWords ().reverseLeftWords ("abcdefg", 2);

        System.out.println (words);
        assertEquals (words, "cdefgab");
    }
}
package com.yixihan.month02.day1206;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-06-15:24
 */
class TruncateSentenceTest {

    TruncateSentence test = new TruncateSentence ();

    @Test
    void truncateSentence() {

        System.out.println (test.truncateSentence ("Hello how are you Contestant", 4));
    }
}
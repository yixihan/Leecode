package com.yixihan.satine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-04-13:57
 */
class CompressStringTest {

    @Test
    void compressString() {
        System.out.println (new CompressString ().compressString ("aabcccccaaa"));
        System.out.println (new CompressString ().compressString (""));
        System.out.println (new CompressString ().compressString ("rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff"));
    }
}
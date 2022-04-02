package com.yixihan.month05.day0313;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-13-9:58
 */
class SolutionTest {

    @Test
    void validUtf8() {
        int[] data = {197,130,1};

        System.out.println (new Solution ().validUtf8 (data));
    }
}
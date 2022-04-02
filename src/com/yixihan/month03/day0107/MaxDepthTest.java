package com.yixihan.month03.day0107;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-07-10:31
 */
class MaxDepthTest {

    MaxDepth test = new MaxDepth ();

    @Test
    void maxDepth1() {
        System.out.println (test.maxDepth ("(1+(2*3)+((8)/4))+1"));
    }

    @Test
    void maxDepth2() {
        System.out.println (test.maxDepth ("(1)+((2))+(((3)))"));
    }

    @Test
    void maxDepth3() {
        System.out.println (test.maxDepth ("1+(2*3)/(2-1)"));
    }

    @Test
    void maxDepth4() {
        System.out.println (test.maxDepth ("1"));
    }
}
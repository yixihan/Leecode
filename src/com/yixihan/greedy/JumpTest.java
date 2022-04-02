package com.yixihan.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-12-14:01
 */
class JumpTest {

    @Test
    void jump() {
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println (new Jump ().jump (nums));
    }
}
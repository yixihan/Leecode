package com.yixihan.month04.day0121;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-01-21-6:50
 */
class MinJumpsTest {

    MinJumps test = new MinJumps ();

    @Test
    void minJumps() {

        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};

        System.out.println (test.minJumps (arr));
    }
}
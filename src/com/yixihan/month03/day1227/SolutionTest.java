package com.yixihan.month03.day1227;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-27-15:01
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void numFriendRequests1() {

        int[] ages = {16,16};
        System.out.println (test.numFriendRequests (ages));
    }

    @Test
    void numFriendRequests2() {

        int[] ages = {16,17,18};
        System.out.println (test.numFriendRequests (ages));
    }

    @Test
    void numFriendRequests3() {

        int[] ages = {20,30,100,110,120};
        System.out.println (test.numFriendRequests (ages));
    }
}
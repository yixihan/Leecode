package com.yixihan.month05.day0224;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-24-13:30
 */
class FindBallTest {

    @Test
    void findBall1() {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        System.out.println (Arrays.toString (new FindBall ().findBall (grid)));
    }

    @Test
    void findBall2() {
        int[][] grid = {{-1}};
        System.out.println (Arrays.toString (new FindBall ().findBall (grid)));
    }
}
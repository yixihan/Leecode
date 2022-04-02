package com.yixihan.month02.day1215;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-15-16:05
 */
class LoudAndRichTest {

    LoudAndRich test = new LoudAndRich ();

    @Test
    void loudAndRich() {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};

        int[] rich = test.loudAndRich (richer, quiet);

        System.out.println (Arrays.toString (rich));
    }
}
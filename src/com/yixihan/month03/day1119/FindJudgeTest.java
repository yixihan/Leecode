package com.yixihan.month03.day1119;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-19-8:20
 */
class FindJudgeTest {

    FindJudge test = new FindJudge ();

    @Test
    void findJudge() {
        int[][] trust = {{1,3},{2,3},{3,1}};

        System.out.println (test.findJudge (3, trust));
    }
}
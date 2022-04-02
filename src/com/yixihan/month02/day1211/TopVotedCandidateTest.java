package com.yixihan.month02.day1211;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-11-15:59
 */
class TopVotedCandidateTest {

    @Test
    void q() {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate test = new TopVotedCandidate (persons, times);

        System.out.println (test.q (3));
        System.out.println (test.q (12));
        System.out.println (test.q (25));
        System.out.println (test.q (15));
        System.out.println (test.q (24));
        System.out.println (test.q (8));
    }
}
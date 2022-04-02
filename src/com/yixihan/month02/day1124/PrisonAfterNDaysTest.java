package com.yixihan.month02.day1124;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-24-16:43
 */
class PrisonAfterNDaysTest {

    PrisonAfterNDays tests = new PrisonAfterNDays();

    @Test
    public void test () {
        int[] ints = new int[]{1,1,0,1,1,0,0,1};
        int[] res = tests.prisonAfterNDays(ints, 300663720);

        System.out.println(Arrays.toString(res));
    }

}
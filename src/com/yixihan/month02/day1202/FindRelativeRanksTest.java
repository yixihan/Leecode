package com.yixihan.month02.day1202;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-02-0:19
 */
class FindRelativeRanksTest {

    FindRelativeRanks test = new FindRelativeRanks ();

    @Test
    void findRelativeRanks() {

        int[] arr = {10,3,8,9,4};

        String[] ranks = test.findRelativeRanks (arr);

        System.out.println (Arrays.toString (ranks));
    }
}
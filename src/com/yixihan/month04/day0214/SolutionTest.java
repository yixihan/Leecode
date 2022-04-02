package com.yixihan.month04.day0214;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-14-11:01
 */
class SolutionTest {

    @Test
    void singleNonDuplicate() {
        int[] nums = {0, 1, 1};
//        int[] nums = {1,1,2,3,3,4,4,8,8};
//        int[] nums = {3,3,7,7,10,11,11};

        System.out.println (new Solution ().singleNonDuplicate (nums));
    }
}
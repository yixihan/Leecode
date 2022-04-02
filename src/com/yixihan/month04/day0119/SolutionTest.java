package com.yixihan.month04.day0119;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-19-6:49
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void containsNearbyDuplicate() {

        int[] nums = {1, 2, 3, 1};

        System.out.println (test.containsNearbyDuplicate (nums, 3));
    }
}
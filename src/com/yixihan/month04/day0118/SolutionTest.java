package com.yixihan.month04.day0118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-18-6:50
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void findMinDifference() {

        List<String> timePoints = new ArrayList<>();
        timePoints.add ("00:00");
        timePoints.add ("23:59");
//        timePoints.add ("01:20");
//        timePoints.add ("01:19");
//        timePoints.add ("01:21");
//        timePoints.add ("10:00");

        System.out.println (test.findMinDifference (timePoints));
    }
}
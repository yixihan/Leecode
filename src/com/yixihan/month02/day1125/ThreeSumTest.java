package com.yixihan.month02.day1125;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-25-16:25
 */
class ThreeSumTest {

    ThreeSum test = new ThreeSum();

    @Test
    void threeSum() {
        int[] arr1 = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = test.threeSum(arr1);

        System.out.println(lists);
    }
}
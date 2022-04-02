package com.yixihan.month02.day1125;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-25-12:45
 */
class TopKFrequentTest {

    TopKFrequent test = new TopKFrequent();

    @Test
    void topKFrequent() {
        int[] arr1 = {1,1,1,2,2,3};
        int[] res1 = test.topKFrequent(arr1, 2);
        System.out.println(Arrays.toString(res1));
    }
}
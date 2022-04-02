package com.yixihan.month02.day1126;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-26-9:46
 */
class GenerateTest {

    Generate test = new Generate();

    @Test
    void generate() {

        System.out.println(test.generate(34));

        List<List<Integer>> lists = test.generate(34);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
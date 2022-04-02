package com.yixihan.month03.day1228;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-28-10:46
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void findAllConcatenatedWordsInADict() {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        List<String> list = test.findAllConcatenatedWordsInADict (words);

        System.out.println (list);
    }
}
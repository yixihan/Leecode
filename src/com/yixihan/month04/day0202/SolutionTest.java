package com.yixihan.month04.day0202;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-02-18:23
 */
class SolutionTest {

    @Test
    void reversePrefix() {
        System.out.println (new Solution ().reversePrefix ("xyxzxe", 'z'));
        System.out.println (new Solution ().reversePrefix ("xyxzxe", 'a'));
    }
}
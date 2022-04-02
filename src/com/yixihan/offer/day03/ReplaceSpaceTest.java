package com.yixihan.offer.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-23-13:05
 */
class ReplaceSpaceTest {

    @Test
    void replaceSpace1() {
        String space = new ReplaceSpace ().replaceSpace ("We are happy.");
        System.out.println (space);

        assertEquals ("We%20are%20happy.", space);
    }

    @Test
    void replaceSpace2() {
        String space = new ReplaceSpace ().replaceSpace ("     ");
        System.out.println (space);

        assertEquals ("%20%20%20%20%20", space);
    }
}
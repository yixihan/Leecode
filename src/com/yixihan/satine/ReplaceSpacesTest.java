package com.yixihan.satine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-03-17:21
 */
class ReplaceSpacesTest {

    @Test
    void replaceSpaces() {

        System.out.println (new ReplaceSpaces ().replaceSpaces ("Mr John Smith    ", 13));
        System.out.println (new ReplaceSpaces ().replaceSpaces ("               ", 5));
    }
}
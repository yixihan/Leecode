package com.yixihan.month03.day0105;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-05-13:27
 */
class ModifyStringTest {

    ModifyString test = new ModifyString ();

    @Test
    void modifyString1() {
        System.out.println (test.modifyString ("?zs"));
    }

    @Test
    void modifyString2() {
        System.out.println (test.modifyString ("ubv?w"));
    }

    @Test
    void modifyString3() {
        System.out.println (test.modifyString ("j?qg??b"));
    }

    @Test
    void modifyString4() {
        System.out.println (test.modifyString ("??yw?ipkj?"));
    }
}
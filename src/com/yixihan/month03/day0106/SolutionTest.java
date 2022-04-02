package com.yixihan.month03.day0106;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-06-12:20
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void simplifyPath1() {

        System.out.println (test.simplifyPath ("/home/"));
    }

    @Test
    void simplifyPath2() {

        System.out.println (test.simplifyPath ("/../"));
    }

    @Test
    void simplifyPath3() {

        System.out.println (test.simplifyPath ("/home//foo/"));
    }

    @Test
    void simplifyPath4() {

        System.out.println (test.simplifyPath ("/a/./b/../../c/"));
    }
}
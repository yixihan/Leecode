package com.yixihan.offer.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-24-14:06
 */
class SearchTest {

    @Test
    void search1() {
        int[] nums = {5,7,7,8,8,10};
        System.out.println (new Search ().search (nums, 8));
    }

    @Test
    void search2() {
        int[] nums = {5,7,7,8,8,10};
        System.out.println (new Search ().search (nums, 6));
    }
}
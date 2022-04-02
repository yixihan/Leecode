package com.yixihan.month01.day1114;


import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2021-11-14-13:52
 */
public class MapSumTest {

    @Test
    public void test () {
        MapSum map = new MapSum();

        map.insert("apple", 3);
        System.out.println(map.sum("ap"));
        map.insert("app", 2);
        System.out.println(map.sum("ap"));
        map.insert("app", 5);
        System.out.println(map.sum("ap"));
    }

}
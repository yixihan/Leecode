package com.yixihan.month04.day0123;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-23-8:46
 */
class StockPriceTest {

    @Test
    public void test1 () {
        StockPrice obj = new StockPrice ();
        obj.update (1, 10);
        obj.update (2, 5);
        System.out.println (obj.current ());
        System.out.println (obj.maximum ());
        obj.update (1, 2);
        System.out.println (obj.maximum ());
        obj.update (4, 2);
        System.out.println (obj.minimum ());
    }

}
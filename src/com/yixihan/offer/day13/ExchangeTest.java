package com.yixihan.offer.day13;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-03-05-14:21
 */
class ExchangeTest {

    @Test
    void exchange() throws Exception {
        Class<Exchange> c = Exchange.class;
        Exchange exchange = c.newInstance ();
        int[] nums = {1, 2, 3, 4};
        int[] ans = exchange.exchange (nums);
        System.out.println (Arrays.toString (ans));

    }
}